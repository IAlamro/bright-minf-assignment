package com.bight.mind.assignment.services.retriever.statement.executers;

import com.bight.mind.assignment.services.retriever.statement.StatementRequest;

public interface StatementRetrieverExecutorServiceFactory {

    StatementRetrieverExecutorService get(StatementRequest statementRequest);
}
