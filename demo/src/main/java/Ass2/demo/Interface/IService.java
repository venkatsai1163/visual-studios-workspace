package Ass2.demo.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Ass2.demo.Model.StudentMarks;



public interface IService {

	List<StudentMarks> getStudentMarksData();
	
	ResponseEntity<StudentMarks> createStudentMarksData(StudentMarks req);
	
	ResponseEntity<StudentMarks> updateStudentMarksData(StudentMarks req);
	
	ResponseEntity<String> deleteStudentMarksDataById(int id);
	
	ResponseEntity<StudentMarks> getStudentMarkDataById(int id);
}
