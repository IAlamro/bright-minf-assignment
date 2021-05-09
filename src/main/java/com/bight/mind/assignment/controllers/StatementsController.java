package com.bight.mind.assignment.controllers;

import com.bight.mind.assignment.entities.Statement;
import com.bight.mind.assignment.services.retriever.statement.StatementRequest;
import com.bight.mind.assignment.services.retriever.statement.StatementRetriever;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatementsController {

    private final StatementRetriever statementRetriever;

    public StatementsController(StatementRetriever statementRetriever) {
        this.statementRetriever = statementRetriever;
    }

    @GetMapping("/admin/users/{userId}/statements")
    public List<Statement> getStatements(@PathVariable("userId") long accountId,
                                         @RequestParam(value = "fromDate", required = false)LocalDate fromDate, @RequestParam(value = "toDate", required = false)LocalDate toDate,
                                         @RequestParam(value = "fromAmount", required = false)double fromAmount, @RequestParam(value = "toAmount", required = false)double toAmount){

        return statementRetriever.retrieve(StatementRequest.builder()
                .accountId(accountId)
                .fromAmount(fromAmount).toAmount(toAmount)
                .fromDate(fromDate).toDate(toDate)
                .build());
    }

    @GetMapping("/user/users/{userId}/statements")
    public List<Statement> getStatements(@PathVariable("userId") long accountId){

        return statementRetriever.retrieve(StatementRequest.builder()
                .accountId(accountId)
                .build());
    }
}
