package mwo.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShopApplication implements InfoContributor {
	private static final Logger logger = LoggerFactory.getLogger(ShopApplication.class);

	@Value("${application.version}")
	private String appVersion;

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("appVersion", appVersion);
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopApplication.class, args);

		// Pobierz wartość wersji z adnotacji @Value
		ShopApplication shopApplication = context.getBean(ShopApplication.class);
		System.out.println("Current application version: " + shopApplication.appVersion);
	}
}
