package dietApp.dietapp.trial;

import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeUsers {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    @PostConstruct
    public void addFakeUsers(){
        List<User> users = new ArrayList<>();
        User admin = new User(
                1L,
                "adas4",
                "Adam",
                passwordEncoder.encode("admin1"),
                "just",
                true,
                "ADMIN"
                );
        User user = new User(
                2L,
                "micha32",
                "Michal",
                passwordEncoder.encode("user1"),
                "just",
                true,
                "USER"
        );
        users.add(admin);
        users.add(user);
        repository.saveAll(users);
    }

}
