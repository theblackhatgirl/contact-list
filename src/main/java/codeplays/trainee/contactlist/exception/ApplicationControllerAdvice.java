package codeplays.trainee.contactlist.exception;

import codeplays.trainee.contactlist.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseException handleBadRequestException(BadRequestException exception) {
        return new ResponseException(exception.getMessage());
    }
}
