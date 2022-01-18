package Ass3.OneToOne.Service;

import Ass3.OneToOne.Model.StudentModel;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStudentService.
 */
public interface IStudentService {

    /**
     * Gets the student data.
     *
     * @return the student data
     */
    List<StudentModel> getStudentData();

    /**
     * Gets the student data by id.
     *
     * @param id the id
     * @return the student data by id
     */
    StudentModel getStudentDataById( int id);

}
