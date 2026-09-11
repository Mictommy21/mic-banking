package com.baraka.mic_banking;

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
				title = "Mic Banking App",
				description = "Backend REST APIs for Mic Banking App",
				version = "v1.0",

				contact = @Contact(
						name = "mictommy Barakah",
						email = "mictommybaraka@gmail.com",
						url = "https://github.com/Mictommy21"
				),

				license = @License(
						name = "The Java Academy",
						url = "https://github.com/Mictommy21"
				)
		),

		externalDocs = @ExternalDocumentation(
				description = "Mic Banking App Documentation",
				url = "https://github.com/Mictommy21"
		)
)
public class MicBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicBankingApplication.class, args);
	}
}