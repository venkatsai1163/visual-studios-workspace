package Ass3.OneToOne.Controller;

import Ass3.OneToOne.Exception.InvalidIdException;
import Ass3.OneToOne.Model.MarksModel;
import Ass3.OneToOne.Model.StudentModel;
import Ass3.OneToOne.Service.IMarksSevice;
import Ass3.OneToOne.Service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /** The log. */
    private final Logger log=LoggerFactory.getLogger(StudentMarksImp.class);

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

        List<MarksModel> list = marksSevice.getMarksData();
        return new ResponseEntity<List<MarksModel>>(list, HttpStatus.OK);
    }

    /**
     * Gets the students.
     *
     * @return the students
     */
    @Override
    public ResponseEntity<List<StudentModel>> getStudents() {

        List<StudentModel> list = studentService.getStudentData();
        return new ResponseEntity<List<StudentModel>>(list, HttpStatus.OK);
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

            StudentModel studentModel=studentService.getStudentDataById(id);
            return new ResponseEntity<StudentModel>(studentModel, HttpStatus.OK);
        }
        else {

            throw new InvalidIdException("Invalid id = "+id);
        }
    }
}
