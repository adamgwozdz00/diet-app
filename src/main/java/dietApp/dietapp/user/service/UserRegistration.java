package dietApp.dietapp.user.service;
import dietApp.dietapp.exception.*;
import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserRegistration {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User user) throws ApplicationRequestException {
        if (isUserCorrectToRegister(user)){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return repository.save(user);
        }
        return null;
    }

    private boolean isUserCorrectToRegister(User user) throws ApplicationRequestException {
        if (isEmailAlreadyExist(user)) throw new EmailAlreadyUsedException(user.getEmail());
        if (isUsernameAlreadyExist(user)) throw new UserAlreadyExistException(user.getUsername());
        if (!isPasswordMatch(user)) throw  new UserPasswordsNotSameException();
        else return true;
    }

    private boolean isEmailAlreadyExist(User user){
        return repository.findUserByEmail(user.getEmail()).isPresent();
    }

    private boolean isUsernameAlreadyExist(User user){
        return repository.findByUsername(user.getUsername()).isPresent();
    }

    private boolean isPasswordMatch(User user){
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
