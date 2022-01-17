package Ass2.demo.Interface;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Ass2.demo.Model.StudentMarks;

public interface IController {
	
	@RequestMapping(value="/studentsMarks",method=RequestMethod.GET)
	List<StudentMarks> getStudentMarks();
	
	@RequestMapping(value="/studentsMarks",method=RequestMethod.POST)
	ResponseEntity<StudentMarks> postStudentMarks(@Valid @RequestBody StudentMarks req);
	
	@RequestMapping(value="/studentsMarks",method=RequestMethod.PUT)
	ResponseEntity<StudentMarks> putStudentMarks(@Valid @RequestBody StudentMarks req);
	
	@RequestMapping(value="/studentsMarks/{id}",method=RequestMethod.DELETE)
	ResponseEntity<String> deleteStudentMarksById(@PathVariable int id);
	
	@RequestMapping(value="/studentsMarks/{id}",method=RequestMethod.GET)
	ResponseEntity<StudentMarks> getStudentMarksById(@PathVariable int id);
}
