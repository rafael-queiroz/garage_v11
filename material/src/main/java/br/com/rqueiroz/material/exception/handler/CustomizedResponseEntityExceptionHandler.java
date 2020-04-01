package br.com.rqueiroz.material.exception.handler;

import br.com.rqueiroz.material.security.exception.InvalidJwtAuthenticationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorObject> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
				.collect(Collectors.toList());

		ErrorResponse errorResponse = ErrorResponse.builder()
				.message("Requisition has invalid fields")
				.timestemp(new Date())
				.details(ex.getBindingResult().getObjectName())
				.errors(errors)
				.build();
		return new ResponseEntity<>(errorResponse, status);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ErrorResponse> handleNoSuchElement(NoSuchElementException ex, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder()
				.message("No records found for this ID")
				.timestemp(new Date())
				.details(request.getDescription(false))
				.errors(null)
				.build();
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ErrorResponse> invalidJwtAuthenticationException(Exception ex, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder()
				.message(ex.getMessage())
				.timestemp(new Date())
				.details(request.getDescription(false))
				.errors(null)
				.build();
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
