package dietApp.dietapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;

    private String date;
    //default
    private DishType dishType = DishType.OTHER;

    private String food;
    private float weight;
    private float calories;
    private float protein;
    private float fat;
    private float carbohydrates;
    private float sugar;

    public Diet(String user, DishType dishType, String food,float weight,float calories, float protein, float fat, float carbohydrates, float sugar, String date) {
        this.user = user;
        this.date = date;
        this.dishType = dishType;
        this.food = food;
        this.weight = weight;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
    }
}
