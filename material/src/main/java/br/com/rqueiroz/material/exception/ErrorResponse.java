package br.com.rqueiroz.material.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse implements Serializable {

	final String message;
	final int code;
	final String status;
	final String objectName;
	final List<ErrorObject> errors;
	
}
