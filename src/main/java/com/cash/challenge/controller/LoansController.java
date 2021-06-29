package com.cash.challenge.controller;

import com.cash.challenge.dao.PageOptions;
import com.cash.challenge.dao.ResultPage;
import com.cash.challenge.entity.*;
import com.cash.challenge.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoansController {

    private static final Logger logger = LoggerFactory.getLogger(LoansController.class);

    @Autowired
    private LoanService loanService;

    @GetMapping("/loans")
    public ResponseEntity<ResultPage<Loan>> getEmpleados(
            @RequestParam(name="page", required=true) Integer page,
            @RequestParam(name="size", required=true) Integer size,
            @RequestParam(name="user_id", required=false) Long userId) {
        LoanFilter filter = null;
        if(userId!=null) {
            filter = new LoanFilter();
            filter.setUserId(userId);
        }
        PageOptions pageOptions = new PageOptions();
        pageOptions.setSize(size);
        pageOptions.setNumber(page);
        ResultPage<Loan> resultPage = loanService.getAllByFilter(filter, pageOptions);
        return ResponseEntity.ok(resultPage);
    }

}
