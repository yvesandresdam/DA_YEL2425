package andres.flights_v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    // Clase dada por ChatGPT
    // Con esta clase es posible evitar la proteccion Cors en peticiones POST desde aplicaciones JAVASCRIPT
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") 
                        .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500") 
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
                        .allowCredentials(true);
            }
        };
    }
}

