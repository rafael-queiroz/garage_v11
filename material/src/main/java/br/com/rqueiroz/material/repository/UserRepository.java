package br.com.rqueiroz.material.repository;

import br.com.rqueiroz.material.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//@Query("SELECT u FROM User u WHERE u.userName =:userName")
	//User findByUsername(@Param("userName") String userName);

	User findByUserName(String userName);
}