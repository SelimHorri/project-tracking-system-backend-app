package com.pfa.app.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.pfa.app.repository.CredentialRepository;

@DataJpaTest
class CredentialRepositoryTest {
	
	@Autowired
	private CredentialRepository credentialRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	@DisplayName("test if username is valid then Credential should be found")
	void testFindByUsername() {
		
	}
	
	
	
}
