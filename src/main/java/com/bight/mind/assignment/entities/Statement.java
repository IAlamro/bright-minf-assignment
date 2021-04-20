package com.bight.mind.assignment.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Statement {

    @Id
    private Long id;

    @JoinColumn(name = "account_id")
    @ManyToOne
    private Account account;

    private LocalDate dateField;

    private Double amount;
}
