package dietApp.dietapp.diet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NutritionValuesDto {
    private double calories;
    private double protein;
    private double fat;
    private double carbs;
    private double sugar;
}
