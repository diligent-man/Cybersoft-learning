package com.ndt.spring.assignment.day_39.config.p2;


import lombok.*;


import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@RequiredArgsConstructor
@Component("btIoCP2Q10DatabaseConfig")
@ConfigurationProperties(prefix = "app.database")
public class Q10DatabaseConfig {
    private String url;

    private String username;
}
