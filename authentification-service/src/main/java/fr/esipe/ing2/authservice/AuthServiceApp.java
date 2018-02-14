package fr.esipe.ing2.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"fr.esipe.ing2.authservice"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class AuthServiceApp {

	public static void main(String[] args) {

		SpringApplication.run(AuthServiceApp.class, args);
	}
}
