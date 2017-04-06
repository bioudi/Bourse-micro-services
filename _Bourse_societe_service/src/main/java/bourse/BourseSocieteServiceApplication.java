package bourse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import bourse.entities.Societe;
@CrossOrigin("*")
@EnableEurekaClient
@SpringBootApplication
public class BourseSocieteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BourseSocieteServiceApplication.class, args);
	}
}

