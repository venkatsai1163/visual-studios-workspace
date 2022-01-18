package Student.StudentMarks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_Marks")
public class StudentMarks {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Column(name="marks_id")
    private int id;
    @Column(name="sub1_m")
    private double mark1;
    @Column(name="sub2_m")
    private double mark2;
    @Column(name="sub3_m")
    private double mark3;
    @Column(name="total")
    private double total;
    @Column(name="grade")
    private String grade;

    @OneToOne(
            optional = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name="Student_id_ref",
            referencedColumnName = "Student_id"
    )
    private Student student;

    public void updateTotal() {
        this.total = Math.ceil(this.mark1+this.mark2+this.mark3);
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
