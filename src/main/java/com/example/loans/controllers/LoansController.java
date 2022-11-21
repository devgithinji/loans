package com.example.loans.controllers;

import com.example.loans.config.LoansServiceConfig;
import com.example.loans.model.Customer;
import com.example.loans.model.Loans;
import com.example.loans.model.Properties;
import com.example.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans != null) {
            return loans;
        } else {
            return null;
        }

    }

    @GetMapping("/loans/properties")
    public String getProperties() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansServiceConfig.getMsg(), loansServiceConfig.getBuildVersion(), loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }
}
