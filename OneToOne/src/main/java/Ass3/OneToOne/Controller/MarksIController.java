package Ass3.OneToOne.Controller;

import Ass3.OneToOne.Model.MarksModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface MarksIController.
 */
public interface MarksIController {

    /**
     * Gets the marks.
     *
     * @return the marks
     */
    @RequestMapping(
            value = "/marks",
            method = RequestMethod.GET
    )
    ResponseEntity<List<MarksModel>> getMarks();

}
