package pl.malek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableWebMvc
//@EnableTransactionManagement
//@EnableJpaRepositories
// Nie wiem czy to musi być przy Spring Boot
public class BikeConfiguratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeConfiguratorApplication.class, args);
    }



}
