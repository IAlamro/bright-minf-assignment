package com.bight.mind.assignment.services.retriever.statement.executers;

import com.bight.mind.assignment.entities.Statement;
import com.bight.mind.assignment.services.retriever.statement.StatementRequest;

import java.util.List;

@FunctionalInterface
public interface StatementRetrieverExecutorService {

    List<Statement> execute(StatementRequest statementRequest);
}
