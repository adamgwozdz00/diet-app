package dietApp.dietapp.food.dto;

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

    public void setNewWeight(float weight) {
        this.calories  = (this.calories/this.weight) * weight;
        this.protein = (this.protein/this.weight) * weight;
        this.fat = (this.fat/this.weight) * weight;
        this.carbohydrates = (this.carbohydrates/this.weight) * weight;
        this.sugar = (this.sugar/this.weight) * weight;
        this.weight = weight;
    }
}
