package com.example.loans.controllers;

import com.example.loans.config.LoansServiceConfig;
import com.example.loans.model.Customer;
import com.example.loans.model.Loans;
import com.example.loans.model.Properties;
import com.example.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LoansController {

    public static final Logger logger = LoggerFactory.getLogger(LoansController.class);


    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestBody Customer customer) {
        logger.info("getLoansDetails() method started");
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        logger.info("getLoansDetails() method started");
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
