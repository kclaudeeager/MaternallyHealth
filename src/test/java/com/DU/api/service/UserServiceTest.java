package com.DU.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.security.auth.message.AuthException;

import com.DU.api.model.User;
import com.DU.api.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepo;
    @Mock
    private UserService userservice;
    @Mock
    User user;

    @Test
    public void testRegisterUser() throws AuthException {

        User testuser = new User("userfname", "userlname", "useer@du.com", "123", 0);
        // int i=l.intValue()
        userservice.registerUser(testuser);

        String emaill = "useer@du.com";

        User userfound = userRepo.findByEmailAddress(emaill);

        int expected = 1;
        int res;
        if (userfound == null) {
            res = 1;
        } else {
            res = 0;
        }
        assertEquals(expected, res);
    }

    @Test
    void testValidateUser() throws AuthException {
        User testuser = new User("userfname", "userlname", "user@du.com", "123", 0);

        userRepo.save(testuser);
        boolean expected = true;
        boolean res;
        String email = "user@du.com";
        String pass = "123";
        User result = userservice.validateUser(email, pass);
        if (result != null) {
            res = false;
        } else {
            res = true;
        }
        // emailSenderService.SendSimpleEmail("ngabojck@gmail.com", "hello", "test");
        // System.out.print(resul);

        assertEquals(expected, res);

    }

}
