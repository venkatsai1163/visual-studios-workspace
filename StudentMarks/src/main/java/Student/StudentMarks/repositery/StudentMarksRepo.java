package Student.StudentMarks.repositery;

import Student.StudentMarks.models.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMarksRepo extends JpaRepository<StudentMarks,Integer> {
}
