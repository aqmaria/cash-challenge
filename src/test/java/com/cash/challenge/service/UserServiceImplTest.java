package com.cash.challenge.service;


import com.cash.challenge.dao.Dao;
import com.cash.challenge.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {

    static final Long VALID_USER_ID = 1L;
    static final Long INVALID_USER_ID = 0L;
    static User validUser = new User();

    @MockBean
    Dao<User,Long> dao;

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
        validUser.setId(VALID_USER_ID);
        validUser.setLastName("LastName");
        validUser.setFirstName("FirstName");
        validUser.setEmail("email@email.com");
        Mockito.when(dao.get(VALID_USER_ID)).thenReturn(validUser);
        Mockito.when(dao.get(INVALID_USER_ID)).thenThrow(NullPointerException.class);
    }

    @Test
    void getUserWithInvalidIdThrowException() {
        Assertions.assertThrows(Exception.class , ()->{
            userService.get(INVALID_USER_ID);
        });
    }

    @Test
    void getUserWithValidIdReturnsUser() {
        User result = userService.get(VALID_USER_ID);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(VALID_USER_ID,result.getId());
    }

}