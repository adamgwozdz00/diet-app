package dietApp.dietapp.user.service;

import dietApp.dietapp.exception.ApplicationRequestException;
import dietApp.dietapp.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRegistration userRegistration;

    public String getCurrentUserUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

    public User registerUser(User user){
        try {
           return userRegistration.registerUser(user);
        } catch (ApplicationRequestException e){
            System.out.println(e.getMessage() +" "+ e.getStatus());
        }
        return null;
    }
}
