package com.bight.mind.assignment.services.retriever.statement.executers;

import com.bight.mind.assignment.entities.Account;
import com.bight.mind.assignment.repository.AccountRepository;
import com.bight.mind.assignment.repository.StatementRepository;
import com.bight.mind.assignment.services.retriever.statement.StatementRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class StatementRetrieverExecuterServiceFactoryImpl implements StatementRetrieverExecuterServiceFactory {

    private StatementRepository statementRepository;
    private AccountRepository accountRepository;

    private Map<Predicate<StatementRequest>, StatementRetrieverExecuterService> instances;

    public StatementRetrieverExecuterServiceFactoryImpl(StatementRepository statementRepository, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.statementRepository = statementRepository;

        this.instances = new HashMap<>();

        instances.put(r -> Objects.isNull(r.getFromDate()) && !Objects.isNull(r.getToDate()) && r.getFromAmount() > 0.0 && r.getToAmount() > 0.0,
                r -> this.statementRepository.findAllByAccountAndDateFieldBetweenAndAmountBetween(getAccount(r.getAccountId()), r.getFromDate(), r.getToDate(), r.getFromAmount(), r.getToAmount()));

        instances.put(r -> Objects.isNull(r.getFromDate()) || Objects.isNull(r.getToDate()),
                r -> this.statementRepository.findAllByAccountAndAmountBetween(getAccount(r.getAccountId()), r.getFromAmount(), r.getToAmount()));

        instances.put(r -> r.getFromAmount() == 0.0 || r.getToAmount() == 0.0,
                r -> this.statementRepository.findAllByAccountAndDateFieldBetween(getAccount(r.getAccountId()), r.getFromDate(), r.getToDate()));

        instances.put(r -> Objects.isNull(r.getFromDate()) || Objects.isNull(r.getToDate()) && (r.getFromAmount() == 0.0 || r.getToAmount() == 0.0),
                r -> this.statementRepository.findAllByAccountAndDateFieldBetween(getAccount(r.getAccountId()), LocalDate.now().minusMonths(3), LocalDate.now()));
    }

    private Account getAccount(long accountId) {
        return this.accountRepository.findById(accountId).orElseThrow(RuntimeException::new);
    }

    public StatementRetrieverExecuterService get(StatementRequest statementRequest){
        //TODO
        return null;
    }
}
