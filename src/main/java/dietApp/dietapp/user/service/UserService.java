package dietApp.dietapp.user.service;

import dietApp.dietapp.exception.ApplicationRequestException;
import dietApp.dietapp.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public boolean registerUser(User user){
        try {
            userRegistration.registerUser(user);
            return true;
        } catch (ApplicationRequestException e){
            System.out.println(e.getMessage() +" "+ e.getStatus());
        }
        return false;
    }

    public String confirmUser(String token){
        return userRegistration.confirmToken(token);
    }
}
