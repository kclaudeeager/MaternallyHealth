package com.DU.api.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.DU.api.model.User;
import com.DU.api.model.staff;
import com.DU.api.service.EmailSenderService;

//import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepo;

    private EmailSenderService emailSenderService;

    @Test
    void testFindByEmailAddress() {

        User testuser = new User("userfname", "userlname", "user@du.com", "123", 0);

        userRepo.save(testuser);
        boolean expected = true;
        boolean res;
        String email = "user@du.com";
        User result = userRepo.findByEmailAddress(email);
        if (result != null) {
            res = true;
        } else {
            res = false;
        }
        // emailSenderService.SendSimpleEmail("ngabojck@gmail.com", "hello", "test");
        // System.out.print(resul);

        assertEquals(expected, res);

    }

    @Test
    void testFindstatusbyemail() {
        User testuser = new User("userfname", "userlname", "user@du.com", "123", 0);

        userRepo.save(testuser);
        int expected = 0;
        String email = "user@du.com";
        int result = userRepo.findstatusbyemail(email);

        assertEquals(expected, result);

    }

    @Test
    void testGetCountByEmail() {

        User testuser = new User("userfname", "userlname", "user@du.com", "123", 0);
        // int i=l.intValue()
        userRepo.save(testuser);
        int expected = 1;
        String email = "user@du.com";
        Long result = userRepo.getCountByEmail(email);
        int res = result.intValue();
        assertEquals(expected, res);

    }

    @Test
    void testSetStatusForUser() {

        User testuser = new User("userfname", "userlname", "user@du.com", "123", 0);
        // int i=l.intValue()
        userRepo.save(testuser);
        int expected = 1;
        String email = "user@du.com";
        userRepo.setStatusForUser(1, email);
        int res = userRepo.findstatusbyemail(email);

        assertEquals(expected, res);

    }
}
