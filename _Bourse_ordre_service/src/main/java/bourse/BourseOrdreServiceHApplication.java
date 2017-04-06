package bourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
public class BourseOrdreServiceHApplication {
	public static void main(String[] args) {
		SpringApplication.run(BourseOrdreServiceHApplication.class, args);
		
	}
}
