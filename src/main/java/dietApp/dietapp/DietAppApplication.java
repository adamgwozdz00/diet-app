package dietApp.dietapp;

import dietApp.dietapp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DietAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DietAppApplication.class, args);
	}

}
