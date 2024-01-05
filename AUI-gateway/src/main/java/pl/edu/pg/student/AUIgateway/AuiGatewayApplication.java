package pl.edu.pg.student.AUIgateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AuiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${aui.gateway.host}") String host
	){
		return builder.routes()
				.route("authors", route -> route
						.host(host)
						.and()
						.path("/api/authors/{uuid}",
								"/api/authors")
						.uri("lb://aui-author"))
				.route("books", route -> route
						.host(host)
						.and()
						.path("/api/books/{uuid}",
								"/api/books",
								"/api/authors/{uuid}/books")
						.uri("lb://aui-book"))
				.build();
	}
}
