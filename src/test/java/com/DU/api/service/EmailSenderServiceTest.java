// package com.DU.api.service;

// import static org.junit.Assert.assertEquals;

// import com.DU.api.service.EmailSenderService;

// import org.aspectj.weaver.loadtime.Agent;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.test.context.junit4.SpringRunner;

// //@RunWith(SpringRunner.class)
// //@SpringBootTest
// @DataJpaTest
// public class EmailSenderServiceTest {

// EmailSenderService emailSenderService;

// @Test
// void testSendSimpleEmail() {
// // String address, String openingHour, String closingHour, String branchname,
// // String staffNumber, String branchManager, String phoneNumber)
// // branch testbranch = new branch("remera", "8am", "9pm", "Kisimenti", "32",
// // "mugabo", "0789378");

// // branchRepo.save(testbranch);
// String expected = "ok";
// String res;
// String email = "ngabojck@gmail.com";
// String body = "hello this the email body for testing";
// String subj = "Test subject";
// z assertEquals(expected, res);

// }

// }

// // public class EmailSenderServiceTest {
// // @Autowired
// // private EmailSenderService emailSenderService;

// // void testSendSimpleEmail() {
// // String email = "ngabojck@gmail.com";
// // String body = "hello this the email body for testing";
// // String subj = "Test subject";
// // // EmailSenderService emailSenderService = new EmailSenderService();
// // String expected = "ok";
// // String res = emailSenderService.SendSimpleEmail(email, body, subj);
// // assertEquals(expected, res);
// // }
// // }
