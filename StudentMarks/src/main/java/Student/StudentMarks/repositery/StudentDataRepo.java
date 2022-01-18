package Student.StudentMarks.repositery;

import Student.StudentMarks.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataRepo extends JpaRepository<Student,Integer> {
}
