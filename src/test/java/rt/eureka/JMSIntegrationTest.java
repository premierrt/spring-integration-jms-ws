package rt.eureka;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import rt.eureka.model.CustomerCanonical;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JMSIntegrationTest {

	
	CustomerCanonical canoncialCustomer;
	
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Autowired
	MessageChannel inboundChannel;
	
	@Autowired
	@Qualifier("jmsConnectionFactory")
	ConnectionFactory jmsConnectionFactory;
	String queueName = InboundAmqConfiguration.QUENAME;
	MessageProducer jmsamqproducer;
	Destination jmsamqdestination;
	Session jmsamqsession;
	Connection jmsamqconn;
	@Before
	public void setUpJmsSession() throws JMSException {
		jmsamqconn = jmsConnectionFactory.createConnection();
		jmsamqconn.start();
		jmsamqsession = jmsamqconn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		jmsamqdestination = jmsamqsession.createQueue(queueName);
		jmsamqproducer = jmsamqsession.createProducer(jmsamqdestination);
		jmsamqproducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		canoncialCustomer = new CustomerCanonical();
	}
	
	@After
	public void tearDownJmsSession() throws JMSException {
		jmsamqsession.close();
		jmsamqconn.close();
		
	}
	@Test
	public void e2eTest() {
	
		canoncialCustomer.setAdress("Polska");
		canoncialCustomer.setId(1);
		canoncialCustomer.setName("rafal");
		try {
			ObjectMessage om= jmsamqsession.createObjectMessage(canoncialCustomer);
			jmsamqproducer.send(jmsamqdestination, om);
            Thread.sleep(3000L);
            assertThat(this.outputCapture.toString().toUpperCase().contains("POLAND"));

		} catch (JMSException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void jmsInboudChannelTest(){
		
	}

}
