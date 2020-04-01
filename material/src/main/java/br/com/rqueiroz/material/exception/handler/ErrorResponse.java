package br.com.rqueiroz.material.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponse implements Serializable {

	final String message;
	final Date timestemp;
	final String details;
	final List<ErrorObject> errors;

	//final int code;
	//final String status;
	//final String objectName;

	
}
