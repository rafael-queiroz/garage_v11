package br.com.rqueiroz.material.security;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class AccountCredentialsVO implements Serializable {

	String username;
	String password;

}
