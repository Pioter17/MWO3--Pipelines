package mwo.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class VersionHolder {

    @Value("${buildNumber}")
    private String version;

    @Bean
    @Primary
    public VersionHolder myVersionHolder() {
        return new VersionHolder();
    }

    public String getVersion() {
        return version;
    }
}
