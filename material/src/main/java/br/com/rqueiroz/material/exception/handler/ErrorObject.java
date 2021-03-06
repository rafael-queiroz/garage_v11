package br.com.rqueiroz.material.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorObject {

    final String message;
    final String field;
    final Object parameter;
}
