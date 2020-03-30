package br.com.rqueiroz.material.exception.handler;

import br.com.rqueiroz.material.exception.ErrorObject;
import br.com.rqueiroz.material.exception.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorObject> errors = getErrors(ex);
		ErrorResponse errorResponse = getErrorResponse(ex, "Requisição possui campos inválidos", status, errors);
		return new ResponseEntity<>(errorResponse, status);
	}

	ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, String message, HttpStatus status, List<ErrorObject> errors) {
		return new ErrorResponse(message, status.value(), status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
	}

	List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
				.collect(Collectors.toList());
	}
}