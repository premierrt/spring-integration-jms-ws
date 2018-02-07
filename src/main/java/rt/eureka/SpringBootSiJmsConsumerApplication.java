package rt.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:springintegration-config.xml"})
public class SpringBootSiJmsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSiJmsConsumerApplication.class, args);
	}
}
