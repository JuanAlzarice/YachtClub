package ar.edu.utn.yachtclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YachtclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(YachtclubApplication.class, args);
        System.out.println("==============================================");
        System.out.println("Aplicación Yacht Club Puerto Madero iniciada!");
        System.out.println("URL: http://localhost:8080/");
        System.out.println("API REST: http://localhost:8080/login");
        System.out.println("==============================================");
    }

}
