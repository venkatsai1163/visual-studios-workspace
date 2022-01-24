package Ass3.OneToOne.testService;

import Ass3.OneToOne.Model.MarksModel;
import Ass3.OneToOne.Model.StudentModel;
import Ass3.OneToOne.Repositery.MarksRepo;
import Ass3.OneToOne.Repositery.StudentRepo;
import Ass3.OneToOne.Service.StudentMarksServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestService {

    @Mock
    MarksRepo marksRepo;

    @Mock
    StudentRepo studentRepo;

    @InjectMocks
    StudentMarksServiceImp studentMarksService;

    @Test
    @DisplayName(value = "Test for get all student data")
    public void getAllData_NullCheck_SizeCheck(){

        List<StudentModel> list = Arrays.asList(
                (new StudentModel().builder()
                        .id(1).name("a").email("a@a.com").mobile("12345").build()),
                (new StudentModel().builder()
                        .id(2).name("b").email("b@b.com").mobile("12345").build())
        );

        when(studentRepo.findAll()).thenReturn(list);

        List<StudentModel> res = studentMarksService.getStudentData();

        Assertions.assertNotNull(res);
        Assertions.assertEquals(res.get(0).getId(),1);
        Assertions.assertEquals(res.get(1).getId(),2);
        org.assertj.core.api.Assertions.assertThat(res.size()).isGreaterThan(0);
    }


    @Test
    @DisplayName(value = "Test for get student data by Id")
    public void getStudentDataById_NullCheck_IdCheck_NameCheck(){

        StudentModel studentModel = new StudentModel().builder()
                .id(1).name("a").email("a@a.com").mobile("12345").build();

        when(studentRepo.findById(anyInt())).thenReturn(studentModel);

        StudentModel res = studentMarksService.getStudentDataById(1);

        Assertions.assertNotNull(res);
        Assertions.assertEquals(res.getId(),1);
        Assertions.assertEquals(res.getName(),"a");
    }

    @Test
    @DisplayName(value = "Test for get all marks data")
    public void getMarsData_NullCheck_TotalCheck_SizeCheck() {

        List<MarksModel> list = Arrays.asList(
                (new MarksModel().builder()
                .mark1(72).mark2(76).mark3(87).id(1).total(235).grade("B").build()),
                (new MarksModel().builder()
                        .mark1(70).mark2(80).mark3(90).id(2).total(240).grade("B").build()));

        when(marksRepo.findAll()).thenReturn(list);

        List<MarksModel> res = studentMarksService.getMarksData();

        Assertions.assertNotNull(res);
        Assertions.assertEquals(res.get(0).getTotal(),235);
        Assertions.assertEquals(res.get(1).getTotal(),240);
        org.assertj.core.api.Assertions.assertThat(res.size()).isGreaterThan(0);
    }

}
