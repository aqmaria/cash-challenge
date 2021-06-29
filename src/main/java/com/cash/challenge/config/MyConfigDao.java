package com.cash.challenge.config;

import com.cash.challenge.entity.Loan;
import com.cash.challenge.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cash.challenge.dao.Dao;
import com.cash.challenge.dao.DaoEntityManagerImpl;

@Configuration
public class MyConfigDao {

    @Bean
    public Dao<User, Long> getUserDao() {
        return new DaoEntityManagerImpl<>(User.class);
    }

    @Bean
    public Dao<Loan, Long> getLoanDao() {
        return new DaoEntityManagerImpl<>(Loan.class);
    }

}
