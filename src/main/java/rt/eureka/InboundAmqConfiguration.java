package rt.eureka;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InboundAmqConfiguration {
	
	public static final String QUENAME = "rt.inbound.queue";
	public static final String TOPIC_NAME = "rt.inbound.topic";
	
	@Bean
	public Queue rtInboundQueue(){
		return new ActiveMQQueue(QUENAME);
	}
	
	@Bean
	public Topic rtInboundTopic(){
		return new ActiveMQTopic( TOPIC_NAME);
	}

}
