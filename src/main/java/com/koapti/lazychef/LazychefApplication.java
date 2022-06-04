package com.koapti.lazychef;

import com.koapti.lazychef.configuration.http.HttpConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Import(HttpConfiguration.class)
public class LazychefApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazychefApplication.class, args);
    }

}
