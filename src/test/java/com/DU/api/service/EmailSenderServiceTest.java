package com.DU.api.service;

// import static org.junit.Assert.assertEquals;

// import com.DU.api.service.EmailSenderService;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.verify;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmailSenderServiceTest {
    @Mock
    private EmailSenderService emailSenderService;

    @Test
    void testSendSimpleEmail() {

        String email = "ngabojck@gmail.com";
        String body = "hello this the email body for testing";
        String subj = "Test subject";
        emailSenderService.SendSimpleEmail(email, body, subj);

    }

}
