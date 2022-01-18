package Student.StudentMarks.controller;

import Student.StudentMarks.models.Student;
import Student.StudentMarks.models.StudentMarks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface Icontroller {

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    List<Student> getStudentData();

    @RequestMapping(value = "/studentMarks",method = RequestMethod.GET)
    List<StudentMarks> getStudentMarks();

    @RequestMapping(value="/student",method=RequestMethod.POST)
    ResponseEntity<Student> createStudent(@RequestBody Student req);

    @RequestMapping(value = "/studentMarks",method =RequestMethod.POST)
    ResponseEntity<StudentMarks> createStudentMarks(@RequestBody StudentMarks req);
}
