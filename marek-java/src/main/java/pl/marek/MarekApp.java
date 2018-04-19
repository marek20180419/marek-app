package pl.marek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pl.marek"})
public class MarekApp {

    public static void main(String[] args) {
        SpringApplication.run(MarekApp.class, args);
    }
}
