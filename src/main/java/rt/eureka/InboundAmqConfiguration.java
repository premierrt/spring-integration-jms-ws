package rt.eureka;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InboundAmqConfiguration {
	
	public static final String QUENAME = "rt.inbound.queue";
	
	@Bean
	public Queue rtInboundQueue(){
		return new ActiveMQQueue(QUENAME);
	}

}
