package dietApp.dietapp.user.registration.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"dietApp.dietapp.user.registration.infrastructure.repository"})
public class DomainsConfig {
}
