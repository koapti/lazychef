package com.koapti.lazychef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// TYMCZASOWY EXCLUDE
// do zastanowienia, czy uzywamy JPA czy JDBC, jesli JPA to bedzie trzeba naprawiac i usunac excluda
// ale chyba bedziemy korzystac z hibernate, wiec moze byc problem
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class LazychefApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazychefApplication.class, args);
    }

}
