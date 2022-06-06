package com.koapti.lazychef.configuration.http;

import com.koapti.lazychef.configuration.http.handlers.HandlersConfiguration;
import com.koapti.lazychef.configuration.http.services.ServicesConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        HandlersConfiguration.class,
        ServicesConfiguration.class
})
public class HttpConfiguration {
}
