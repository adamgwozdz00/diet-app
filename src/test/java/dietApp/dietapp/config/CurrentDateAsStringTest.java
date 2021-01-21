package dietApp.dietapp.config;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentDateAsStringTest {

    @Test
    void shouldReturnCorrectDate(){
        //given
        String today = "2021-01-21";
        //when
        String currentDate = CurrentDateAsString.getTodayDate();
        //then
        assertThat(currentDate).isEqualTo(today);
    }

}