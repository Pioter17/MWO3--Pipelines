package mwo.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		Properties properties = new Properties();

		String version = properties.getProperty("application.version");
		System.out.println("Current application version: " + version);

		SpringApplication.run(ShopApplication.class, args);
	}

}
