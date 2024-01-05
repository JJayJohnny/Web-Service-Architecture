package pl.edu.pg.student.AUIeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AuiEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiEurekaApplication.class, args);
	}

}
