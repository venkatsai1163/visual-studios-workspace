package Ass2.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import Ass2.demo.Model.StudentMarks;
import Ass2.demo.Interface.IController;
import Ass2.demo.Interface.IService;
import Ass2.demo.StudentExceptions.DataExistException;
import Ass2.demo.StudentExceptions.DataNotFoundException;


@RestController
public class Controller implements IController{
	
	@Autowired
	private IService service;
	

	@Override
	public List<StudentMarks> getStudentMarks() {
		return service.getStudentMarksData();
	}

	@Override
	public ResponseEntity<StudentMarks> postStudentMarks(StudentMarks req) {
		ResponseEntity<StudentMarks> res=service.createStudentMarksData(req);
		if(res==null)
			throw new DataExistException("Data aleady Exist");
		else
			return res;
	}

	@Override
	public ResponseEntity<StudentMarks> putStudentMarks(StudentMarks req){
		ResponseEntity<StudentMarks> res=service.updateStudentMarksData(req);
		if(res==null)
			throw new DataNotFoundException("Data dosen't exist");
		else
			return res;
	}

	@Override
	public ResponseEntity<String> deleteStudentMarksById(int id){
		ResponseEntity<String> res=service.deleteStudentMarksDataById(id);
		if(res==null)
			throw new DataNotFoundException("Data dosen't exist");
		else
			return res;
	}

	@Override
	public ResponseEntity<StudentMarks> getStudentMarksById(int id) {
		ResponseEntity<StudentMarks> res=service.getStudentMarkDataById(id);
		if(res==null)
			throw new DataNotFoundException("Data dosen't exist");
		else
			return res;
	}
	
	
}
