package com.cash.challenge.service;

import com.cash.challenge.dao.*;
import com.cash.challenge.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private Dao<Loan, Long> dao;

    private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Override
    public ResultPage<Loan> getAllByFilter(LoanFilter filter, PageOptions pageOptions) {
        logger.trace("getAllByFilter");
        ResultPage<Loan> result = new ResultPage<Loan>();
        try{
            result = this.dao.get( filter, pageOptions);
        }catch (Exception e){
            logger.error( "getAllByFilter["+ filter.toString() +
                    pageOptions.toString() +
                    "exception:" + e.toString()+"]");
        }
        return result;
    }

}
