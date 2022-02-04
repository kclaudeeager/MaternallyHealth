// package com.DU.api.service;

// import static org.junit.Assert.assertEquals;

// import javax.security.auth.message.AuthException;

// import com.DU.api.model.User;
// import com.DU.api.repository.UserRepository;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;

// //@DataJpaTest
// //@SpringBootTest
// public class UserServiceTest {

// @Autowired
// public UserRepository userRepo;
// @Autowired
// private UserService userservice;

// @Test
// public void testRegisterUser() {

// User testuser = new User("userfname", "userlname", "user@du.com", "123", 0);
// // int i=l.intValue()
// // userservice.registerUser(testuser);
// // userRepo.save(testuser);
// try {
// userservice.registerUser(testuser);
// } catch (AuthException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }

// // userRepo.findByEmailAddress(testuser.getEmail());
// // userservice.validateUser("user@du.com", "123");
// // int expected = 1;
// // String email = "user@du.com";
// // userRepo.setStatusForUser(1, email);
// // int res = userRepo.findstatusbyemail(email);
// // assertEquals(expected, res);
// }

// @Test
// void testValidateUser() {

// }
// }
