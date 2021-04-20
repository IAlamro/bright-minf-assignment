package com.bight.mind.assignment.repository;

import com.bight.mind.assignment.entities.Account;
import com.bight.mind.assignment.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {


    List<Statement> findAllByAccountAndAmountBetween(Account account, Double fromAmount, Double toAmount);

    List<Statement> findAllByAccountAndDateFieldBetween(Account account, LocalDate fromDate, LocalDate toDate);

    List<Statement> findAllByAccountAndDateFieldBetweenAndAmountBetween(Account account, LocalDate fromDate, LocalDate toDate, Double fromAmount, Double toAmount);
}
