package dietApp.dietapp.user.registration.service.impl;

import dietApp.dietapp.exception.UserAlreadyExistException;
import dietApp.dietapp.exception.UserPasswordsNotSameException;
import dietApp.dietapp.model.User;
import dietApp.dietapp.user.registration.service.UserRegistrationService;
import dietApp.dietapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(dietApp.dietapp.model.User user) throws Exception {
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
