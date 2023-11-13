package mwo.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@SpringBootApplication
public class ShopApplication {

	private static final Logger logger = LoggerFactory.getLogger(ShopApplication.class);
	public static void main(String[] args) {
		logger.info("Starting the application...");

		Properties properties = new Properties();
		String version = properties.getProperty("application.version");
		logger.info("Current application version: {}", version);

		SpringApplication.run(ShopApplication.class, args);

		logger.info("Application started successfully.");
	}

}
