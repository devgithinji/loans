package com.example.loans.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_number",nullable = false)
    private int loanNumber;

    @Column(name = "customer_id",nullable = false)
    private int customerId;

    @Column(name="start_dt",nullable = false)
    private Date startDt;

    @Column(name = "loan_type",nullable = false,length = 100)
    private String loanType;

    @Column(name = "total_loan",nullable = false)
    private int totalLoan;

    @Column(name = "amount_paid",nullable = false)
    private int amountPaid;

    @Column(name = "outstanding_amount",nullable = false)
    private int outstandingAmount;

    @Column(name = "create_dt")
    private String createDt;

}
