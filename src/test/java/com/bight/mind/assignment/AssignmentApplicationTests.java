package com.bight.mind.assignment;

import com.bight.mind.assignment.entities.Account;
import com.bight.mind.assignment.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	void contextLoads() {
		accountRepository.save(new Account());
	}

}
