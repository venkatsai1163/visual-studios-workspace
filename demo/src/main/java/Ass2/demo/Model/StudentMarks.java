package Ass2.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Id;

@Entity
@Table(name="Marks")
public class StudentMarks implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StudentId")
	private int id;
	
	@Column(name="StudentName")
	@NotNull(message="name should not be null")
	@Pattern(regexp="[A-Za-z ]{3,25}$",message="lenght should be between 3-25")
	private String name;
	
	@Column(name="Sub1")
	@Range(min=0,max=100,message="marks should be between 0-100")
	private double mark1;
	
	@Column(name="Sub2")
	@Range(min=0,max=100,message="marks should be between 0-100")
	private double mark2;
	
	@Column(name="Sub3")
	@Range(min=0,max=100,message="marks should be between 0-100")
	private double mark3;
	
	@Column(name="TotalMarks")
	@Range(min=0,max=300,message="total should be between 0-300")
	private double total;
	
	@Column(name="StudentGrade")
	@NotNull(message="grade should no be null")
	@Pattern(regexp="\\s*|[A-D F]{1}$",message="grade should be A,B,C,D,F or Empty('') only")
	private String grade;
	
	protected StudentMarks(){}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public double getMark1() {
		return mark1;
	}

	public void setMark1(double mark1) {
		this.mark1 = mark1;
	}

	public double getMark2() {
		return mark2;
	}

	public void setMark2(double mark2) {
		this.mark2 = mark2;
	}

	public double getMark3() {
		return mark3;
	}

	public void setMark3(double mark3) {
		this.mark3 = mark3;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void updateTotal()
	{
		this.total=Math.ceil(mark1+this.mark2+this.mark3);
	}
	
	public void updateGrade()
	{
		if(this.total>=275)
			this.grade="A";
		else if(this.total>=250)
			this.grade="B";
		else if(this.total>=225)
			this.grade="C";
		else if(this.total>=200)
			this.grade="D";
		else
			this.grade="F";
		}
}
