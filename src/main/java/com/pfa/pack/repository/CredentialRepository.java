package com.pfa.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.pack.model.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
	
	Optional<Credential> findByUsername(final String username);
	
}
