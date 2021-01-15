package dietApp.dietapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UserTest {

    private static Validator validator;
    private static User user;

    @BeforeEach
    public void setupValidatorInstance(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        user = new User(1L,"user1","George","secret123","secret123",true,"USER");
    }


    @ParameterizedTest
    @ValueSource(strings = {""," ","  "})
    public void shouldReturnIncorrectToEmptyUsername(String incorrectUserName){
        //given
        user.setUsername(incorrectUserName);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"x","sh","asdfghjklqwert56yuio0"})
    public void shouldReturnIncorrectToShortOrToLongUsername(String incorrectUserName){
        //given
        user.setUsername(incorrectUserName);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCorrectUsername(){
        //given
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnIncorrectToShortPassword(){
        //given
        String incorrectUserPassword = "asdfg";
        user.setPassword(incorrectUserPassword);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnIncorrectEmptyPassword(){
        //given
        String incorrectUserPassword = " ";
        user.setPassword(incorrectUserPassword);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(2);
    }

    @Test
    public void shouldReturnCorrectPassword(){
        //given
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnIncorrectEmptyConfirmPassword(){
        //given
        user.setConfirmPassword("");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(1);
    }

    //it pass test if only user class settings is compatible.
    @ParameterizedTest
    @ValueSource(strings = {"a","vs","hahahahhahaha"})
    public void shouldReturnCorrectConfirmPassword(String confirmPassword){
        //given
        user.setConfirmPassword(confirmPassword);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        //when
        //then
        assertThat(violations.size()).isEqualTo(0);
    }


}