package com.github.br11.web.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(App.class, args);

		SpringApplication app = new SpringApplication(App.class);

		Properties properties = new Properties();
		properties.setProperty("spring.datasource.username",
				Files.lines(Paths.get("/etc/secret/dbuser")).findFirst().get());
		properties.setProperty("spring.datasource.password",
				Files.lines(Paths.get("/etc/secret/dbpass")).findFirst().get());

		app.setDefaultProperties(properties);
		app.run(args);
	}

}
