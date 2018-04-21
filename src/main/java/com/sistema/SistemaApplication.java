package com.sistema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner {
    
        private static final Logger log = LoggerFactory.getLogger(SistemaApplication.class);

       
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}
        
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE");
              }
        };
    }
        
    @Override
    public void run(String... strings) throws Exception {        
        log.info("Run.... Cargado ");
    }
}
