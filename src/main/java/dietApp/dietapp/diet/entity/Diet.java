package dietApp.dietapp.diet.entity;

import lombok.*;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;
    private String date;
    private DishType dishType = DishType.OTHER;
    private String food;
    private float weight;
    private float calories;
    private float protein;
    private float fat;
    private float carbohydrates;
    private float sugar;

}
