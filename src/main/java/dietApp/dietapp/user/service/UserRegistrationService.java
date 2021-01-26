package dietApp.dietapp.user.service;
import dietApp.dietapp.exception.ApplicationRequestException;
import dietApp.dietapp.exception.UserAlreadyExistException;
import dietApp.dietapp.exception.UserPasswordsNotSameException;
import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService{

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    public User registerUser(User user) throws ApplicationRequestException {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            try {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                repository.save(user);
                return user;
            } catch (Exception e){
                throw new UserAlreadyExistException(user.getUsername());
            }
        }
        else throw new UserPasswordsNotSameException();
    }
}
