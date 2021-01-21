package dietApp.dietapp.diet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"dietApp.dietapp.diet.repository"})
public class DietConfig {
}
