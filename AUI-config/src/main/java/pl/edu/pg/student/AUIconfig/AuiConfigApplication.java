package pl.edu.pg.student.AUIconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AuiConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiConfigApplication.class, args);
	}

}
