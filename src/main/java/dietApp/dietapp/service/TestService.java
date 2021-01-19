package dietApp.dietapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dietApp.dietapp.client.FoodApiService;
import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final FoodApiService foodApiService;

    @Scheduled(fixedDelay = 12000)
    void print() throws JsonProcessingException {
        System.out.println(foodApiService.mapClientToFood("chocolate"));
    }

}
