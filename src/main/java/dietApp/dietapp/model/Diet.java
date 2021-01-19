package dietApp.dietapp.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import java.util.Date;

@Entity
public class Diet {

    @Id
    private Long user_id;

    private Date date;
    //default
    private DishType dishType = DishType.OTHER;

    private String food;


}
