package Ass2.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ass2.demo.Interface.IRepo;
import Ass2.demo.Model.StudentMarks;

@Repository
public interface StudentRepo extends JpaRepository<StudentMarks,Integer>,IRepo{
	StudentMarks findById(int id);
}
