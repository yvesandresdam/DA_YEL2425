package andres.flights_v31;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "andres.flights_v31")
@EnableJpaRepositories(basePackages = "andres.flights_v31.Repository")
public class SpringConfig {
}
