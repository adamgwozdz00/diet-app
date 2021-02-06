package dietApp.dietapp.user.service;
import dietApp.dietapp.exception.*;
import dietApp.dietapp.user.email.EmailSender;
import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import dietApp.dietapp.user.token.ConfirmationToken;
import dietApp.dietapp.user.token.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static dietApp.dietapp.user.email.EmailFormula.buildEmail;


@Component
@RequiredArgsConstructor
public class UserRegistration {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    public User registerUser(User user) throws ApplicationRequestException {
        if (isUserCorrectToRegister(user)){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            String token = confirmationTokenService.createConfirmationToken(user);
            emailSender.send(
                    user.getEmail(),
                    buildEmail(user.getName(), "http://localhost:8080/register/confirm?token="+token)
            );
            return user;
        }
        return null;
    }

    public String confirmToken(String token){
        ConfirmationToken t = confirmationTokenService.getToken(token).orElseThrow();
        User user = t.getUser();
        if (isTokenNotExpired(t)){
            repository.enableUser(user.getUsername()) ;
            confirmationTokenService.setConfirmedAt(token);
            return "Successfully confirmed";
        } else{
            return "Token expired";
        }
    }

    private boolean isTokenNotExpired(ConfirmationToken token){
        return !token.getExpiredAt().isBefore(LocalDateTime.now());
    }

    private boolean isUserCorrectToRegister(User user) throws ApplicationRequestException {
        if (isEmailAlreadyExist(user))
            throw new EmailAlreadyUsedException(user.getEmail());
        if (isUsernameAlreadyExist(user))
            throw new UserAlreadyExistException(user.getUsername());
        if (!isPasswordMatch(user))
            throw new UserPasswordsNotSameException();
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
