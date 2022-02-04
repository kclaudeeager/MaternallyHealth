package com.DU.api.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.DU.api.model.Logs;
import com.DU.api.model.agents;
import com.DU.api.model.branch;
import com.DU.api.model.client;

//import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class LogsRepositoryTest {
    @Autowired
    private LogsRepository logsRepo;

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

    @Test
    void testSavelog() {

    }
}
