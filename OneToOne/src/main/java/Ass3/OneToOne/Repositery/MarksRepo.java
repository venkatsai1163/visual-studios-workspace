package Ass3.OneToOne.Repositery;

import Ass3.OneToOne.Model.MarksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface MarksRepo.
 */
@Repository
public interface MarksRepo extends JpaRepository<MarksModel,Integer> {

}
