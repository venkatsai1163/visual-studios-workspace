package Ass2.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Ass2.demo.Model.StudentMarks;
import Ass2.demo.Interface.IService;
import Ass2.demo.Repo.StudentRepo;

@Service
public class StudentService implements IService{
	
	@Autowired
	private StudentRepo repo;
	
	@Override
	public List<StudentMarks> getStudentMarksData() {
		return repo.findAll();
	}

	@Override
	public ResponseEntity<StudentMarks> createStudentMarksData(StudentMarks req) {
		if(repo.existsById(req.getId()))
			return null;
		else
		{
		req.updateTotal();
		req.updateGrade();
		return new ResponseEntity<StudentMarks>(repo.save(req),HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<StudentMarks> updateStudentMarksData(StudentMarks req) {
		if(repo.existsById(req.getId()))
		{
		req.updateTotal();
		req.updateGrade();
		return new ResponseEntity<StudentMarks>(repo.save(req),HttpStatus.OK);
		}
		else
		return null;
	}

	@Override
	public ResponseEntity<String> deleteStudentMarksDataById(int id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
			return null;
	}

	@Override
	public ResponseEntity<StudentMarks> getStudentMarkDataById(int id) {
		if(repo.existsById(id))
		{
			StudentMarks res=repo.findById(id);
			return new ResponseEntity<StudentMarks>(res,HttpStatus.FOUND);
		}
		else
			return null;
	}

}
