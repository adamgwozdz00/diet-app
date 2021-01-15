//package dietApp.dietapp.trial;
//
//import dietApp.dietapp.model.User;
//import dietApp.dietapp.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class FakeUsers {
//
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepository repository;
//
//    @PostConstruct
//    public void addFakeUsers(){
//        List<User> users = new ArrayList<>();
//        User admin = new User(
//                "adas4",
//                "Adam",
//                passwordEncoder.encode("admin1"),
//                "ADMIN"
//                );
//        User user = new User(
//                "micha32",
//                "Michal",
//                passwordEncoder.encode("user1"),
//                "USER"
//        );
//        users.add(admin);
//        users.add(user);
//        repository.saveAll(users);
//    }
//
//}
