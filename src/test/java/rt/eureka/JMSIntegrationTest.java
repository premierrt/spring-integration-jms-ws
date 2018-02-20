package rt.eureka;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.integration.annotation.Payload;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.core.Context;
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
//	@Test
//	public void e2eTest() {
//	
//		canoncialCustomer.setAdress("Polska");
//		canoncialCustomer.setId(1);
//		canoncialCustomer.setName("rafal");
//		try {
//			ObjectMessage om= jmsamqsession.createObjectMessage(canoncialCustomer);
//			jmsamqproducer.send(jmsamqdestination, om);
//            Thread.sleep(3000L);
//            assertThat(this.outputCapture.toString().toUpperCase().contains("POLAND"));
//
//		} catch (JMSException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}
	
	@Test
	public void createXMLTextMessageTest() throws JAXBException, JMSException, InterruptedException{
		
		canoncialCustomer.setAdress("Polska");
		canoncialCustomer.setId(1);
		canoncialCustomer.setName("rafal");
		JAXBContext jaxbContext = JAXBContext.newInstance(CustomerCanonical.class);
		
		Marshaller marsz = jaxbContext.createMarshaller();
		marsz.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		marsz.marshal(canoncialCustomer, outStream);
		System.out.println(outStream.toString());
		TextMessage tm = jmsamqsession.createTextMessage(outStream.toString());
		jmsamqproducer.send(jmsamqdestination, tm);
		Thread.sleep(10000L);
    //  assertThat(this.outputCapture.toString().toUpperCase().contains("POLAND"));
		
	}
	
	

}
