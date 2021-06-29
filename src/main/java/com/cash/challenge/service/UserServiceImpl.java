package com.cash.challenge.service;

import com.cash.challenge.dao.Dao;
import com.cash.challenge.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Dao<User, Long> dao;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User get(Long id) {
        logger.trace("get id:" + id.toString());
        User user = null;
        try{
            user = this.dao.get(id);
        }catch (RuntimeException e){
            logger.error("get[userId:"+id.toString()+"exception:"+e.toString()+"]");
        }
        return user;
    }

    @Override
    @Transactional
    public void insert(User user) {
        logger.trace("insert :" + user.toString() );
        try{
            dao.insert(user);
        }catch (RuntimeException e){
            logger.error("insert["+user.toString()+e.toString()+"]");
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        logger.trace("delete :"+ id.toString());
        try{
            dao.delete(id);
        }catch (RuntimeException e){
            logger.error("delete[userId:"+id.toString()+"]");
            throw e;
        }
    }


}
