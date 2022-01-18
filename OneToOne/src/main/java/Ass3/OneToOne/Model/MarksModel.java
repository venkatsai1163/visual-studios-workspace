package Ass3.OneToOne.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MarksModel.
 */
@Entity
@Table(name = "Marks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarksModel {

    /** The id. */
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "Mark_id")
    private int id;

    /** The mark 1. */
    @Column(name = "Sub1_M")
    private double mark1;

    /** The mark 2. */
    @Column(name = "Sub2_M")
    private double mark2;

    /** The mark 3. */
    @Column(name = "Sub3_M")
    private double mark3;

    /** The total. */
    @Column(name = "Total")
    private double total;

    /** The grade. */
    @Column(name = "Grade")
    private String grade;

    /** The student model. */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "Student_ref_id",
            referencedColumnName = "Student_id"
    )
    @JsonBackReference
    private StudentModel studentModel;

    /**
     * Update total.
     */
    public void updateTotal() {
        this.total = Math.ceil(this.mark1+this.mark2+this.mark3);
    }

    /**
     * Update grade.
     */
    public void updateGrade()
    {
        if(this.total >= 275)
            this.grade = "A";
        else if(this.total >= 250)
            this.grade = "B";
        else if(this.total >= 225)
            this.grade = "C";
        else if(this.total >= 200)
            this.grade = "D";
        else
            this.grade = "F";
    }
}
