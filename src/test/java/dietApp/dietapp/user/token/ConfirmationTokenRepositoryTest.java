package dietApp.dietapp.user.token;

import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConfirmationTokenRepositoryTest {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private UserRepository userRepository;
    private ConfirmationToken confirmationToken;

    @BeforeEach
    void init(){
        User user = new User();
        user.setActive(false);
        user.setUsername("Username");
        user.setEmail("email@email.com");
        user.setPassword("secret123");
        userRepository.save(user);
        confirmationToken = new ConfirmationToken(
                "123-token-456",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
                );
        confirmationTokenRepository.save(confirmationToken);
    }

    @Test
    void shouldSetConfirmedAt(){
        //given
        String token = "123-token-456";
        System.out.println(confirmationToken.getConfirmedAt());
        //when
        confirmationTokenRepository.updateConfirmedAt(token,LocalDateTime.now());
        confirmationToken = confirmationTokenRepository.findByToken(token).orElseThrow();
        //then
        assertNotNull(confirmationToken.getConfirmedAt());
    }

}