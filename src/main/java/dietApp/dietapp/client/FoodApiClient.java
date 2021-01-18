package dietApp.dietapp.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FoodApiClient {

    private static String API_URL = "https://api.edamam.com/api/nutrition-data?nutrition-type=logging";
    private static String API_ID = "677c950a";
    private static String API_KEY ="181299622f631740f83ec712e5706e09";
    private RestTemplate restTemplate = new RestTemplate();

    public Object getFoodAsString(String foodName){
        return restTemplate.getForEntity(
                API_URL + "&app_id={app_id}&app_key={app_key}&ingr={ingredient}",
                Object.class,
                API_ID, API_KEY, foodName
        ).getBody();
    }

}
