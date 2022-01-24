package Ass3.OneToOne.testHttpRequests;

import Ass3.OneToOne.Controller.StudentMarksImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class TestHttpRequest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentMarksImp studentMarksImp;

    @Test
    public void getMethod_getAllStudents(){

        
    }
}
