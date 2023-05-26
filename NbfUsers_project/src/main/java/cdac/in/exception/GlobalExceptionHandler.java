// Class to handle exception Globally
package cdac.in.exception;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value
					= ExceptionClass.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorResponse
	handleException(ExceptionClass ex)
	{
		return new ErrorResponse(
			HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	

	
	
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public List<Validate> handleValidationErrors(MethodArgumentNotValidException ex) {
	        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
//	                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//	        List<String> errorsfiled = ex.getBindingResult().getFieldErrors()
//	                .stream().map(FieldError::getField).collect(Collectors.toList());
//			return new ResponseEntity<Object>(getErrorsMap(errors,errorsfiled), HttpStatus.BAD_REQUEST);
			return getErrorsMap(errors);
	        
	    }

	    private List<Validate> getErrorsMap(List<FieldError> errors) {
	    	
	    	List<Validate>  errorResponse = new ArrayList();
            for (FieldError fieldError : errors) {
				errorResponse.add(new Validate(fieldError.getField(), fieldError.getDefaultMessage()));
			}
	        return errorResponse;
	    }
	
}
