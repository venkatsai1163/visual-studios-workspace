package Ass3.OneToOne.testController;

import Ass3.OneToOne.Controller.StudentMarksImp;
import Ass3.OneToOne.Exception.InvalidIdException;
import Ass3.OneToOne.Model.MarksModel;
import Ass3.OneToOne.Model.StudentModel;
import Ass3.OneToOne.Service.IMarksSevice;
import Ass3.OneToOne.Service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestController {

    @Mock
    IMarksSevice iMarksSevice;

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentMarksImp studentMarksImp;


    @Test
    public void getAllStudentsData() {

        List<StudentModel> list = Arrays.asList(
                (new StudentModel().builder()
                        .id(1).name("a").email("a@a.com").mobile("12345").build()),
                (new StudentModel().builder()
                        .id(2).name("b").email("b@b.com").mobile("12345").build())
        );

        when(iStudentService.getStudentData()).thenReturn(list);

        ResponseEntity<List<StudentModel>> res = studentMarksImp.getStudents();

        Assertions.assertNotNull(res);
        Assertions.assertEquals(res.getStatusCodeValue(),200);
        Assertions.assertEquals(res.getBody().size(),2);
    }

    @Nested
    class StudentDataById {

        @Test
        public void getStudentDataById() {

            StudentModel studentModel = new StudentModel().builder()
                    .id(1).name("a").email("a@a.com").mobile("12345").build();

            when(iStudentService.getStudentDataById(anyInt())).thenReturn(studentModel);

            ResponseEntity<StudentModel> res = studentMarksImp.getStudentById(1);

            Assertions.assertNotNull(res);
            Assertions.assertEquals(res.getStatusCodeValue(), 200);
            Assertions.assertEquals(res.getBody().getId(), 1);
        }

        @Test
        public void getStudentDataById_ThrowException() {

            Assertions.assertThrowsExactly(InvalidIdException.class, () -> studentMarksImp.getStudentById(-1));
        }
    }

    @Test
    public void getMarksData(){

        List<MarksModel> list = Arrays.asList(
                (new MarksModel().builder()
                        .mark1(72).mark2(76).mark3(87).id(1).total(235).grade("B").build()),
                (new MarksModel().builder()
                        .mark1(70).mark2(80).mark3(90).id(2).total(240).grade("B").build()));

        when(iMarksSevice.getMarksData()).thenReturn(list);

        ResponseEntity<List<MarksModel>> res = studentMarksImp.getMarks();

        Assertions.assertNotNull(res);
        Assertions.assertEquals(res.getStatusCodeValue(),200);
        Assertions.assertEquals(res.getBody().size(),2);
    }
}
