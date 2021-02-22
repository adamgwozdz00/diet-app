package dietApp.dietapp.user.repository;

import dietApp.dietapp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    Optional<User>findByUsername(String username);

    @Transactional(readOnly = true)
    Optional<User>findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.active = true WHERE u.username =?1")
    int enableUser(String username);
}
