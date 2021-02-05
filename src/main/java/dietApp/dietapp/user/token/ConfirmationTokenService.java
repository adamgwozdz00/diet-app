package dietApp.dietapp.user.token;

import dietApp.dietapp.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository repository;

    public Optional<ConfirmationToken> getToken(String token) {
        return repository.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return repository.updateConfirmedAt(token,LocalDateTime.now());
    }

    public String createConfirmationToken(User user){
        String token = UUID.randomUUID().toString();
        repository.save(new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        ));
        return token;
    }


}
