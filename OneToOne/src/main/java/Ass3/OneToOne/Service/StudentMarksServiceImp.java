package Ass3.OneToOne.Service;

import Ass3.OneToOne.Model.MarksModel;
import Ass3.OneToOne.Model.StudentModel;
import Ass3.OneToOne.Repositery.MarksRepo;
import Ass3.OneToOne.Repositery.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentMarksServiceImp.
 */
@Service
public class StudentMarksServiceImp implements IMarksSevice,IStudentService{

    /** The marks repo. */
    @Autowired
    MarksRepo marksRepo;

    /** The student repo. */
    @Autowired
    StudentRepo studentRepo;

    /**
     * Gets the marks data.
     *
     * @return the marks data
     */
    @Override
    public List<MarksModel> getMarksData() {

        return marksRepo.findAll();
    }

    /**
     * Gets the student data.
     *
     * @return the student data
     */
    @Override
    public List<StudentModel> getStudentData() {

        return studentRepo.findAll();
    }

    /**
     * Gets the student data by id.
     *
     * @param id the id
     * @return the student data by id
     */
    @Override
    public StudentModel getStudentDataById(int id) {

        return studentRepo.findById(id);
    }
}
