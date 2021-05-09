package com.bight.mind.assignment.services.retriever.statement.executers;

import com.bight.mind.assignment.entities.Account;
import com.bight.mind.assignment.entities.Statement;
import com.bight.mind.assignment.repository.AccountRepository;
import com.bight.mind.assignment.repository.StatementRepository;
import com.bight.mind.assignment.services.retriever.statement.StatementRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestConfig.class)
public class StatementRetrieverExecutorServiceFactoryTest {
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private StatementRepository statementRepository;

    @InjectMocks
    private StatementRetrieverExecutorServiceFactoryImpl executorServiceFactory;

    @Test
    public void givenFullStatementRequest_whenCallingGetMethod_thenListOfStatementShouldBeReturned() {
        List<Statement> statements = Collections.singletonList(new Statement());

        Mockito
                .when(statementRepository
                        .findAllByAccountAndDateFieldBetweenAndAmountBetween(
                                Mockito.any(Account.class),
                                eq(LocalDate.now()),
                                eq(LocalDate.now()),
                                Mockito.anyDouble(),
                                Mockito.anyDouble()))
                .thenReturn(statements);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Account()));

        StatementRequest statementRequest = StatementRequest.builder()
                .accountId(1)
                .fromDate(LocalDate.now()).toDate(LocalDate.now())
                .fromAmount(1.0).toAmount(Double.MAX_VALUE)
                .build();

        StatementRetrieverExecutorService executorService = r -> this.statementRepository
                .findAllByAccountAndDateFieldBetweenAndAmountBetween(
                        accountRepository.findById(r.getAccountId()).get(),
                        r.getFromDate(),
                        r.getToDate(),
                        r.getFromAmount(),
                        r.getToAmount());

        Assert.assertEquals(executorService.execute(statementRequest),
                executorServiceFactory.get(statementRequest).execute(statementRequest));
    }


    @Test
    public void givenStatementRequestWithoutDate_whenCallingGetMethod_thenListOfStatementShouldBeReturned() {
        List<Statement> statements = Collections.singletonList(new Statement());

        Mockito
                .when(statementRepository
                        .findAllByAccountAndAmountBetween(
                                Mockito.any(Account.class),
                                Mockito.anyDouble(),
                                Mockito.anyDouble()))
                .thenReturn(statements);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Account()));

        StatementRequest statementRequest = StatementRequest.builder()
                .accountId(1)
                .fromAmount(1.0).toAmount(Double.MAX_VALUE)
                .build();

        StatementRetrieverExecutorService executorService = r -> this.statementRepository
                .findAllByAccountAndAmountBetween(accountRepository.findById(r.getAccountId()).get(), r.getFromAmount(), r.getToAmount());

        Assert.assertEquals(executorService.execute(statementRequest),
                executorServiceFactory.get(statementRequest).execute(statementRequest));
    }


    @Test
    public void givenStatementRequestWithoutAmount_whenCallingGetMethod_thenListOfStatementShouldBeReturned() {
        List<Statement> statements = Collections.singletonList(new Statement());

        Mockito
                .when(statementRepository
                        .findAllByAccountAndDateFieldBetween(
                                Mockito.any(Account.class),
                                eq(LocalDate.now()),
                                eq(LocalDate.now())))
                .thenReturn(statements);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Account()));

        StatementRequest statementRequest = StatementRequest.builder()
                .accountId(1)
                .fromDate(LocalDate.now()).toDate(LocalDate.now())
                .build();

        StatementRetrieverExecutorService executorService = r -> this.statementRepository
                .findAllByAccountAndDateFieldBetween(accountRepository.findById(r.getAccountId()).get(), r.getFromDate(), r.getToDate());

        Assert.assertEquals(executorService.execute(statementRequest),
                executorServiceFactory.get(statementRequest).execute(statementRequest));
    }


    @Test
    public void givenStatementRequestWithoutDateAndAmount_whenCallingGetMethod_thenListOfStatementShouldBeReturned() {
        List<Statement> statements = Collections.singletonList(new Statement());

        Mockito
                .when(statementRepository
                        .findAllByAccountAndDateFieldBetween(
                                Mockito.any(Account.class),
                                eq(LocalDate.now()),
                                eq(LocalDate.now())))
                .thenReturn(statements);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Account()));

        StatementRequest statementRequest = StatementRequest.builder()
                .accountId(1)
                .build();

        StatementRetrieverExecutorService executorService = r -> this.statementRepository
                .findAllByAccountAndDateFieldBetween(accountRepository.findById(r.getAccountId()).get(), LocalDate.now().minusMonths(3),
                        LocalDate.now());
        Assert.assertEquals(executorService.execute(statementRequest),
                executorServiceFactory.get(statementRequest).execute(statementRequest));
    }

    @Test(expected = RuntimeException.class)
    public void givenWrongStatementRequest_whenCallingGetMethod_thenRuntimeExceptionShouldBeThrown() {
        StatementRequest statementRequest = StatementRequest.builder().accountId(-1).build();
        executorServiceFactory.get(statementRequest).execute(statementRequest);
    }

}