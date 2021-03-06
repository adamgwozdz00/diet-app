package dietApp.dietapp.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"dietApp.dietapp.user.repository"})
public class UserConfig {
}
