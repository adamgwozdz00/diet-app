package dietApp.dietapp.user.repository;

import dietApp.dietapp.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void init(){
        User user = new User();
        user.setActive(false);
        user.setUsername("Username");
        user.setEmail("email@email.com");
        user.setPassword("secret123");
        repository.save(user);
    }

    @Test
    void shouldUpdateUserActivityTrue(){
        //given
        User user;
        String username = "Username";
        //when
        repository.enableUser(username);
        user = repository.findByUsername(username).orElseThrow();
        //then
        assertTrue(user.isActive());
    }




}