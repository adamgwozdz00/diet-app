package dietApp.dietapp.service;

import dietApp.dietapp.model.Diet;
import dietApp.dietapp.model.DishType;
import dietApp.dietapp.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
class DietServiceTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DietRepository dietRepository;
    @Autowired
    private DietService service;

    private Date date;

    @BeforeEach
    void init(){
        date = new Date();
    }

    @Test
    void shouldReturnCorrectSizeOfUserDiet() {
    //given
        service.addFoodToDiet(1L,DishType.DINNER,"egg");
        service.addFoodToDiet(1L,DishType.DINNER,"chicken");
    //when
        List<Diet> found = dietRepository.findAllByUserId(1L);
    //then
        assertThat(found.size()).isEqualTo(2);
    }
}