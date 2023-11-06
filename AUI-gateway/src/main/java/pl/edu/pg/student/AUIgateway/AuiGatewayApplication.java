package pl.edu.pg.student.AUIgateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${aui.book.url}") String bookUrl,
			@Value("${aui.author.url}") String authorUrl,
			@Value("${aui.gateway.host}") String host
	){
		return builder.routes()
				.route("authors", route -> route
						.host(host)
						.and()
						.path("/api/authors/{uuid}",
								"/api/authors")
						.uri(authorUrl))
				.route("books", route -> route
						.host(host)
						.and()
						.path("/api/books/{uuid}",
								"/api/books",
								"/api/authors/{uuid}/books")
						.uri(bookUrl))
				.build();
	}
}
