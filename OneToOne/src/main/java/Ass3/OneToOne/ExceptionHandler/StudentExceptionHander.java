package Ass3.OneToOne.ExceptionHandler;

import Ass3.OneToOne.Exception.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentExceptionHander.
 */
@ControllerAdvice
public class StudentExceptionHander extends ResponseEntityExceptionHandler {

    /**
     * Handle invlaid id exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(
            value = InvalidIdException.class
    )
    public ResponseEntity<Object> handleInvlaidIdException(InvalidIdException ex)
    {

        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

}
