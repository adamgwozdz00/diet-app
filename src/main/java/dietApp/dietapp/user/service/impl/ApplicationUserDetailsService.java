package dietApp.dietapp.user.service.impl;

import dietApp.dietapp.exception.UserAlreadyExistException;
import dietApp.dietapp.model.User;
import dietApp.dietapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);

        user.orElseThrow(()-> new UserAlreadyExistException("Not found: " + username));

        return user.map(ApplicationUserDetails::new).get();
    }
}
