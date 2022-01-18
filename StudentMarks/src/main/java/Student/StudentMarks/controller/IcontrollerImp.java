package Student.StudentMarks.controller;

import Student.StudentMarks.Service.Iservice;
import Student.StudentMarks.models.Student;
import Student.StudentMarks.models.StudentMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IcontrollerImp implements Icontroller {

    @Autowired
    private Iservice service;

    @Override
    public List<Student> getStudentData() {
        return service.getStudentData();
    }

    @Override
    public List<StudentMarks> getStudentMarks() {
        return service.getStudentMarksData();
    }

    @Override
    public ResponseEntity<Student> createStudent(Student req) {
        return new ResponseEntity<Student>(service.createStudent(req), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StudentMarks> createStudentMarks(StudentMarks req) {
        return new ResponseEntity<StudentMarks>(service.createStudentMarks(req),HttpStatus.CREATED);
    }
}
