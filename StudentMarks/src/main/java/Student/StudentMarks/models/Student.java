package Student.StudentMarks.models;


import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;


@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "Student_id")
    private int id;
    @Column(name = "Student_name")
    private String name;
    @Column(name="Student_email")
    private String email;
    @Column(name = "Student_mobile")
    private String mobile;
}
