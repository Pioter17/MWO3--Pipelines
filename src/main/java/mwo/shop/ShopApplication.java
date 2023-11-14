package mwo.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ShopApplication.class);

	@Value("${info.app.version}")
	private String appVersion;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Current application version: " + appVersion);
		System.out.println("111111111111111111111111111!!!!!!!!!!!!!!!!!!!!!!!!111111111111111111111111111");
	}
}
