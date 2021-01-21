package dietApp.dietapp.repository;


import dietApp.dietapp.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietRepository extends JpaRepository<Diet,Long> {

    List<Diet>findAllByUserAndDate(String username, String date);

}
