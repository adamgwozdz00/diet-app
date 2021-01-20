package dietApp.dietapp.client.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
