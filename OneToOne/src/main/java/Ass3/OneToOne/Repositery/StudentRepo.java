package Ass3.OneToOne.Repositery;

import Ass3.OneToOne.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentRepo.
 */
@Repository
public interface StudentRepo extends JpaRepository< StudentModel , Integer > {

    /**
     * Find by id.
     *
     * @param id the id
     * @return the student model
     */
    StudentModel findById(int id);

}
