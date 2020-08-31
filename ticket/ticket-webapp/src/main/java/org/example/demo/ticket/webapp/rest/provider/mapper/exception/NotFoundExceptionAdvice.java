package org.example.demo.ticket.webapp.rest.provider.mapper.exception;




import org.example.demo.ticket.webapp.rest.provider.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link NotFoundExceptionAdvice} pour les {@link ResourceNotFoundException}
 *
 * @author Pierrot Mongonnam
 */

@ControllerAdvice
public class NotFoundExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String resourceNotFoundHandler(ResourceNotFoundException pException) {
        return pException.getMessage();
    }
}
