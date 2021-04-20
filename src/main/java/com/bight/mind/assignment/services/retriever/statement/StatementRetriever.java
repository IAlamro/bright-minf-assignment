package com.bight.mind.assignment.services.retriever.statement;

import com.bight.mind.assignment.entities.Statement;
import com.bight.mind.assignment.services.Query;

import java.util.List;

public interface StatementRetriever extends Query<StatementRequest, List<Statement>> {
}
