package dietApp.dietapp.diet.repository;


import dietApp.dietapp.diet.dto.NutritionValuesDto;

import dietApp.dietapp.diet.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface DietRepository extends JpaRepository<Diet,Long> {

    List<Diet>findAllByUserAndDate(String username, String date);

    @Query(value = "SELECT new dietApp.dietapp.diet.dto.NutritionValuesDto(SUM(d.calories),SUM(d.protein),SUM(d.fat),SUM(d.carbohydrates),SUM(d.sugar)) FROM Diet d WHERE d.user =?1 AND d.date =?2")
    Optional<NutritionValuesDto> getTotalNutritionValues(String username, String date);

}
