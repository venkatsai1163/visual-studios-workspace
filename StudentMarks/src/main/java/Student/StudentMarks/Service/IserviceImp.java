package Student.StudentMarks.Service;

import Student.StudentMarks.models.Student;
import Student.StudentMarks.models.StudentMarks;
import Student.StudentMarks.repositery.StudentDataRepo;
import Student.StudentMarks.repositery.StudentMarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IserviceImp implements  Iservice{

    @Autowired
    private StudentDataRepo repo;

    @Autowired
    private StudentMarksRepo marksRepo;

    @Override
    public List<Student> getStudentData() {
        return repo.findAll();
    }

    @Override
    public List<StudentMarks> getStudentMarksData() {
        return marksRepo.findAll();
    }

    @Override
    public Student createStudent(Student req) {
        
        return this.repo.save(req);
    }

    @Override
    public StudentMarks createStudentMarks(StudentMarks req) {
        req.updateTotal();
        req.updateGrade();
        return this.marksRepo.save(req);
    }
}
