package com.cash.challenge.service;

import com.cash.challenge.dao.PageOptions;
import com.cash.challenge.dao.ResultPage;
import com.cash.challenge.entity.*;

import java.util.List;

public interface LoanService {

    ResultPage<Loan> getAllByFilter(LoanFilter filter, PageOptions pageOptions);

}
