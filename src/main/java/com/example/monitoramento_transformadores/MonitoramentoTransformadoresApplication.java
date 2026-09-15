package com.example.monitoramento_transformadores;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitoramentoTransformadoresApplication {
	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI()
				.info(new Info()
						.title("API de Monitoramento Térmico de Transformadores")
						.version("1.0.0")
						.description("Sistema de gestão de ativos elétricos, medições térmicas e emissão automática de alertas.")
						.contact(new Contact()
								.name("Suporte Técnico")
								.email("daniel_e_dapper@estudante.sesisenai.org.br"))
						.license(new License()
								.name("Apache 2.0")
								.url("https://www.apache.org/licenses/LICENSE-2.0")));
	}

	public static void main(String[] args) {
		SpringApplication.run(MonitoramentoTransformadoresApplication.class, args);
	}

}
