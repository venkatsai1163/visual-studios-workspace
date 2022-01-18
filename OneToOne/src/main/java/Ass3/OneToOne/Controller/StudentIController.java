package Ass3.OneToOne.Controller;

import Ass3.OneToOne.Model.StudentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentIController.
 */
public interface StudentIController {

    /**
     * Gets the students.
     *
     * @return the students
     */
    @RequestMapping(
            value = "/students",
            method = RequestMethod.GET
    )
    ResponseEntity<List<StudentModel>> getStudents();

    /**
     * Gets the student by id.
     *
     * @param id the id
     * @return the student by id
     */
    @RequestMapping(
            value = "/student/{id}",
            method = RequestMethod.GET
    )
    ResponseEntity<StudentModel> getStudentById( @PathVariable(value = "id") int id );

}
