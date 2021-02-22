package dietApp.dietapp.user.repository;

import dietApp.dietapp.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;
    @Autowired
    TestEntityManager entityManager;

    @Test
    void shouldUpdateUserActivity() {
        //given
        User user = new User();
        prepareUserData(user);
        user = entityManager.persistAndFlush(user);
        //when
        int result = repository.enableUser(user.getUsername());
        //then
        assertThat(result).isEqualTo(1);
    }

    void prepareUserData(User user){
        user.setActive(false);
        user.setUsername("Username");
        user.setEmail("email@email.com");
        user.setPassword("secret123");
    }



}
