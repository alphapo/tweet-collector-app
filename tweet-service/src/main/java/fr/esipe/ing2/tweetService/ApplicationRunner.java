package fr.esipe.ing2.tweetService;

import fr.esipe.ing2.common.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"fr.esipe.ing2.tweetService", "fr.esipe.ing2.common"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ApplicationRunner {

        public static void main(String[] args) {

            SpringApplication.run(ApplicationRunner.class, args);
        }
}