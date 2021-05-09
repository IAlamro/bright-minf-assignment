package com.bight.mind.assignment;

import com.bight.mind.assignment.entities.Account;
import com.bight.mind.assignment.entities.Statement;
import com.bight.mind.assignment.repository.AccountRepository;
import com.bight.mind.assignment.repository.StatementRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
@ComponentScan("com.bight.mind.assignment.services.retriever.statement.executers")
public class TestConfig {

    @Bean
    public StatementRepository statementRepository(){
        return new StatementRepository() {
            @Override
            public List<Statement> findAllByAccountAndAmountBetween(Account account, Double fromAmount, Double toAmount) {
                return null;
            }

            @Override
            public List<Statement> findAllByAccountAndDateFieldBetween(Account account, LocalDate fromDate, LocalDate toDate) {
                return null;
            }

            @Override
            public List<Statement> findAllByAccountAndDateFieldBetweenAndAmountBetween(Account account, LocalDate fromDate, LocalDate toDate, Double fromAmount, Double toAmount) {
                return null;
            }

            @Override
            public List<Statement> findAll() {
                return null;
            }

            @Override
            public List<Statement> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Statement> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends Statement> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Statement> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Statement> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Statement getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Statement> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Statement> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Statement> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Statement> S save(S s) {
                return null;
            }

            @Override
            public Optional<Statement> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Statement statement) {

            }

            @Override
            public void deleteAll(Iterable<? extends Statement> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Statement> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Statement> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Statement> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Statement> boolean exists(Example<S> example) {
                return false;
            }
        };
    }

    @Bean
    public AccountRepository accountRepository(){

        return new AccountRepository() {
            @Override
            public List<Account> findAll() {
                return null;
            }

            @Override
            public List<Account> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Account> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Account> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Account> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Account getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Account> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Account> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Account> S save(S s) {
                return null;
            }

            @Override
            public Optional<Account> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Account account) {

            }

            @Override
            public void deleteAll(Iterable<? extends Account> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Account> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Account> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Account> boolean exists(Example<S> example) {
                return false;
            }
        };
    }
}
