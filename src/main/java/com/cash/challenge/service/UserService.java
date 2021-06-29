package com.cash.challenge.service;

import com.cash.challenge.entity.User;

import java.util.List;

public interface UserService {
    User get(Long id);

    void insert(User user);

    void delete(Long id);

}
