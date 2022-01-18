package Ass3.OneToOne.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentModel.
 */
@Entity
@Table(name = "Student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {

    /** The id. */
    @Id
    @Column(name = "Student_id")
    private int id;

    /** The name. */
    @Column(name = "Student_name")
    private String name;

    /** The email. */
    @Column(name = "Student_email")
    private String email;

    /** The mobile. */
    @Column(name = "Student_mobile")
    private String mobile;

    /** The marks model. */
    @OneToOne(
            mappedBy = "studentModel",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private MarksModel marksModel;

}
