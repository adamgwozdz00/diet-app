package dietApp.dietapp.user.registration.infrastructure;

import dietApp.dietapp.model.User;


public interface UserRegistrationService {

    User registerUser(User user) throws Exception;

}
