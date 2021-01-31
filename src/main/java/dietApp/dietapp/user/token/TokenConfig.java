package dietApp.dietapp.user.token;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"dietApp.dietapp.user.token"})
public class TokenConfig {

}
