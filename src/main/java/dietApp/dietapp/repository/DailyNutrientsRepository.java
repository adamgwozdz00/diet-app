package dietApp.dietapp.repository;

import dietApp.dietapp.model.DailyNutrients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyNutrientsRepository extends JpaRepository<DailyNutrients,Long> {
}
