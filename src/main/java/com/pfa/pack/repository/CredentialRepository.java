package com.pfa.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfa.pack.model.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
	
	@Query(name = "Optional.findByUsername", nativeQuery = true)
	public abstract Optional<Credential> findByUsername(@Param("username") final String username);
	
}
