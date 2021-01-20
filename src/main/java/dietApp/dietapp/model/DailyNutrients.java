package dietApp.dietapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DailyNutrients {

    @Id
    private Long userId;

    private Date date;

    private float calories;
    private float protein;
    private float fat;
    private float carbohydrates;
    private float sugar;

}
