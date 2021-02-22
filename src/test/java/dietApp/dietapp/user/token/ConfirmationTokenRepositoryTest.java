package dietApp.dietapp.user.token;

import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ConfirmationTokenRepositoryTest {

    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;


    @Test
    void shouldUpdateConfirmationToken(){
        //given
        User user = entityManager.persistAndFlush(prepareUserData());
        ConfirmationToken confirmationToken = entityManager.persistAndFlush(prepareTokenData(user));
        //when
        int result = confirmationTokenRepository.updateConfirmedAt(confirmationToken.getToken(),LocalDateTime.now());
        //then
        assertThat(result).isEqualTo(1);
    }

    ConfirmationToken prepareTokenData(User user){
        return new ConfirmationToken(
                "123-token-456",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
    }

    User prepareUserData(){
        User user = new User();
        user.setActive(false);
        user.setUsername("Username");
        user.setEmail("email@email.com");
        user.setPassword("secret123");
        return user;
    }

}
