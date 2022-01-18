package Ass3.OneToOne.Controller;

import Ass3.OneToOne.Exception.InvalidIdException;
import Ass3.OneToOne.Model.MarksModel;
import Ass3.OneToOne.Model.StudentModel;
import Ass3.OneToOne.Service.IMarksSevice;
import Ass3.OneToOne.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentMarksImp.
 */
@RestController
public class StudentMarksImp implements StudentIController,MarksIController{

    /** The student service. */
    @Autowired
    IStudentService studentService;

    /** The marks sevice. */
    @Autowired
    IMarksSevice marksSevice;

    /**
     * Gets the marks.
     *
     * @return the marks
     */
    @Override
    public ResponseEntity<List<MarksModel>> getMarks() {

        return new ResponseEntity<List<MarksModel>>(marksSevice.getMarksData(), HttpStatus.OK);
    }

    /**
     * Gets the students.
     *
     * @return the students
     */
    @Override
    public ResponseEntity<List<StudentModel>> getStudents() {

        return new ResponseEntity<List<StudentModel>>(studentService.getStudentData(), HttpStatus.OK);
    }

    /**
     * Gets the student by id.
     *
     * @param id the id
     * @return the student by id
     */
    @Override
    public ResponseEntity<StudentModel> getStudentById(int id) {

        if( id != 0
                && id > 0) {

            return new ResponseEntity<StudentModel>(studentService.getStudentDataById(id), HttpStatus.OK);
        }
        else {

            throw new InvalidIdException("Invalid id = "+id);
        }
    }
}
