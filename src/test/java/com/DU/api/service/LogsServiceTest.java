package com.DU.api.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.DU.api.model.Logs;
import com.DU.api.model.Baby;
import com.DU.api.model.Hospital;
import com.DU.api.model.Mother;
import com.DU.api.repository.LogsRepository;

//import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class LogsServiceTest {
    @Mock
    private LogsService logsService;
    @Mock
    private LogsRepository logsRepo;
    @Mock
    Logs logs;

    @Test
    public void testSavelog() {
        Date now = new Date();
        Date d = new Date();

        Logs testLogs = new Logs(d, "user@du.com", "createdtestcase");

        logsRepo.save(testLogs);
        boolean expected = true;
        boolean res;
        String email = "user@du.com";
        List<Logs> result = logsRepo.findLogsByEmail(email);
        if (result != null) {
            res = true;
        } else {
            res = false;
        }

        assertEquals(expected, res);

    }

    @Test
    void testFindLogsByEmail() {
        // Date time, String email, String activity
        Date d = new Date();

        Logs testLogs = new Logs(d, "user@du.com", "createdtestcase");

        logsRepo.save(testLogs);
        boolean expected = true;
        boolean res;
        String email = "user@du.com";
        List<Logs> result = logsRepo.findLogsByEmail(email);
        if (result != null) {
            res = true;
        } else {
            res = false;
        }

        assertEquals(expected, res);

    }
}
