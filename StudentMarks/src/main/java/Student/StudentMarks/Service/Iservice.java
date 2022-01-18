package Student.StudentMarks.Service;

import Student.StudentMarks.models.Student;
import Student.StudentMarks.models.StudentMarks;

import java.util.List;

public interface Iservice {

    List<Student> getStudentData();

    List<StudentMarks> getStudentMarksData();

    Student createStudent(Student req);

    StudentMarks createStudentMarks(StudentMarks req);

}
