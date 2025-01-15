package com.enviro.assessment.grad001.mahloniKhumbuza;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Enviro365 REST API Documentation",
				description = "APIs for Enviro365 Interview Assessment",
				version = "v1",
				contact = @Contact(
						name = "Mahloni Khumbuza",
						email = "mahloni91@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "REST API endpoints for managing waste\n" +
						"categories, disposal guidelines, and recycling tips.",
				url = "https://google.com"
		)
)
public class MahloniKhumbuzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahloniKhumbuzaApplication.class, args);
	}

}
