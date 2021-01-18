package dietApp.dietapp.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Food {

    private String name;
    private float weight;
    private float calories;
    private float protein;
    private float fat;
    private float carbohydrates;
    private float sugar;

}
