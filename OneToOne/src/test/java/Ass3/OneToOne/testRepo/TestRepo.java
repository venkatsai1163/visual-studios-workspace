package Ass3.OneToOne.testRepo;

import Ass3.OneToOne.Model.StudentModel;
import Ass3.OneToOne.Repositery.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//test for Repositery without using mokito...
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //give not to repalce with spring_memory_db
public class TestRepo {

    @Mock
    private StudentRepo studentRepo;


    @Test
    public void testGetAllStudents(){

        List<StudentModel> list= Arrays.asList(
                (new StudentModel().builder()
                        .id(1).name("a").email("a@a.com").mobile("12345").build()),
                (new StudentModel().builder()
                        .id(2).name("b").email("b@b.com").mobile("12345").build())
        );

        when(studentRepo.findAll()).thenReturn(list);

        List<StudentModel> res = studentRepo.findAll();

        Assertions.assertNotNull(res);
        assertThat(res
                .size()).isGreaterThan(0);
    }

}