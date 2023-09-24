package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Long>{

	Optional<Login> findByEmail(String email);

	@Query("select id from Login where email=:email")
	Optional<Long> findIdByEmail(String email);

}
