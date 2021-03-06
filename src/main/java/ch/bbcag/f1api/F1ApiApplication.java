package ch.bbcag.f1api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //Für LogIn Page ausschalten
public class F1ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(F1ApiApplication.class, args);
    }

}
