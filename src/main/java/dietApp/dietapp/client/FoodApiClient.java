package dietApp.dietapp.client;

import dietApp.dietapp.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FoodApiClient {

    private String API_URL;
    private String API_ID;
    private String API_KEY;
    private final RestTemplate restTemplate;

    private FoodApiClient(@Value("${API_URL}") String API_URL, @Value("${API_ID}") String API_ID, @Value("${API_KEY}") String API_KEY, RestTemplate restTemplate) {
        this.API_URL = API_URL;
        this.API_ID = API_ID;
        this.API_KEY = API_KEY;
        this.restTemplate = restTemplate;
    }

    public Object getFoodAsObject(String foodName){
        return restTemplate.getForEntity(
                API_URL + "&app_id={app_id}&app_key={app_key}&ingr={ingredient}",
                Object.class,
                API_ID, API_KEY, foodName
        ).getBody();
    }

}
