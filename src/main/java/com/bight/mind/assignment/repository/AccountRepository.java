package com.bight.mind.assignment.repository;

import com.bight.mind.assignment.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
}
