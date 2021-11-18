package br.com.ronna.ms.visita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MsVisitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsVisitaApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){return new RestTemplate();}

}
