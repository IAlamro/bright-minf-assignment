package com.bight.mind.assignment.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    private Long id;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "statement", cascade = CascadeType.ALL)
    private List<Statement> statements;
}
