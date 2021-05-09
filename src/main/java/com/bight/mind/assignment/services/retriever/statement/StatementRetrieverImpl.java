package com.bight.mind.assignment.services.retriever.statement;

import com.bight.mind.assignment.entities.Statement;
import com.bight.mind.assignment.services.retriever.statement.executers.StatementRetrieverExecutorServiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementRetrieverImpl implements StatementRetriever{

    private StatementRetrieverExecutorServiceFactory statementRetrieverExecuterServiceFactory;

    public StatementRetrieverImpl(StatementRetrieverExecutorServiceFactory statementRetrieverExecuterServiceFactory) {
        this.statementRetrieverExecuterServiceFactory = statementRetrieverExecuterServiceFactory;
    }

    @Override
    public List<Statement> retrieve(StatementRequest statementRequest) {
        return statementRetrieverExecuterServiceFactory.get(statementRequest).execute(statementRequest);
    }
}
