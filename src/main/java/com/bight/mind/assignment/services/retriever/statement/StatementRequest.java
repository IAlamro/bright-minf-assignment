package com.bight.mind.assignment.services.retriever.statement;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
public class StatementRequest {

    private long accountId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private double fromAmount;
    private double toAmount;
}
