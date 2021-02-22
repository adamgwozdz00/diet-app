package dietApp.dietapp.user.service;

import dietApp.dietapp.user.entity.User;
import dietApp.dietapp.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
class ApplicationUserDetailsServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ApplicationUserDetailsService service;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThrowUserNotExistException(){
        //given
        String username = "username";
        given(userRepository.findByUsername(username)).willReturn(Optional.empty());
        //when
        UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class,()->service.loadUserByUsername(username));
        //then
        assertTrue(thrown.getMessage().contains("Not found: " + username));
    }

    @Test
    void shouldLoadUserByUsernameAndGrandHimAuthorities(){
        //given
        User user = prepareUser();
        given(userRepository.findByUsername(user.getUsername()))
                .willReturn(Optional.ofNullable(user));
        //when
        Collection<? extends GrantedAuthority> expect = Arrays.stream(new String [] {"USER","ADMIN"})
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        Collection<? extends GrantedAuthority> result = service.loadUserByUsername(user.getUsername()).getAuthorities();
        //then
        assertThat(result).isEqualTo(expect);

    }

    private User prepareUser(){
        return new User(
                1L,
                "Username",
                "name",
                "email@email.com",
                "secret12345",
                "secret12345",
                true,
                "USER,ADMIN");
    }



}
