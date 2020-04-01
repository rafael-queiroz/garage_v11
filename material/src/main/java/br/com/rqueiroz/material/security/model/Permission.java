package br.com.rqueiroz.material.security.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String description;

	@Override
	public String getAuthority() {
		return null;
	}
}
