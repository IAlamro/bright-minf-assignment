package com.bight.mind.assignment.services.retriever.statement.executers;

import com.bight.mind.assignment.entities.Account;
import com.bight.mind.assignment.repository.AccountRepository;
import com.bight.mind.assignment.repository.StatementRepository;
import com.bight.mind.assignment.services.retriever.statement.StatementRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class StatementRetrieverExecutorServiceFactoryImpl implements StatementRetrieverExecutorServiceFactory {

    private final StatementRepository statementRepository;
    private final AccountRepository accountRepository;

    public StatementRetrieverExecutorServiceFactoryImpl(StatementRepository statementRepository, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.statementRepository = statementRepository;
    }

    private Account getAccount(long accountId) {
        return this.accountRepository.findById(accountId).orElseThrow(RuntimeException::new);
    }

    public StatementRetrieverExecutorService get(StatementRequest statementRequest) {
        try {
            if (!Objects.isNull(statementRequest.getFromDate())
                    && !Objects.isNull(statementRequest.getToDate())
                    && statementRequest.getFromAmount() > 0.0 && statementRequest.getToAmount() > 0.0)
                return r -> this.statementRepository
                        .findAllByAccountAndDateFieldBetweenAndAmountBetween(
                                getAccount(r.getAccountId()),
                                r.getFromDate(),
                                r.getToDate(),
                                r.getFromAmount(),
                                r.getToAmount());
            else if (Objects.isNull(statementRequest.getFromDate()) || Objects.isNull(statementRequest.getToDate()))
                return r -> this.statementRepository
                        .findAllByAccountAndAmountBetween(getAccount(r.getAccountId()), r.getFromAmount(), r.getToAmount());
            else if (statementRequest.getFromAmount() == 0.0 || statementRequest.getToAmount() == 0.0)
                return r -> this.statementRepository
                        .findAllByAccountAndDateFieldBetween(getAccount(r.getAccountId()), r.getFromDate(), r.getToDate());
            else if (Objects.isNull(statementRequest.getFromDate()) || Objects.isNull(statementRequest.getToDate())
                    && (statementRequest.getFromAmount() == 0.0 || statementRequest.getToAmount() == 0.0))
                return r -> this.statementRepository
                        .findAllByAccountAndDateFieldBetween(getAccount(r.getAccountId()), LocalDate.now().minusMonths(3),
                                LocalDate.now());
            else
                throw new RuntimeException("Invalid request");
        }catch (RuntimeException e){
            throw new RuntimeException("Invalid request");
        }
    }
}
