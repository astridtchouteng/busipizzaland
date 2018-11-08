package be.busi.pizzaland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PizzalandApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzalandApplication.class, args);
    }
}
