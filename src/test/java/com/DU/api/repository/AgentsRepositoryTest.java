package com.DU.api.repository;

import static org.junit.Assert.assertEquals;

import com.DU.api.model.agents;

import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AgentsRepositoryTest {
    @Autowired
    private AgentsRepository agentRepo;

    @Test
    void testFindAgentByIdNumber() {
        agents agent1 = new agents("jackson", "ngabo", "0794803", "passport", "1997827382",
                "withdraw", "kicukiro", "32573");
        // String firstName, String lastName, String phoneNumber, String idtype, String
        // idnumber,
        // String services, String residance, String capital
        agentRepo.save(agent1);
        String expected = agent1.getPhoneNumber();
        String idn = "1997827382";
        agents result = agentRepo.findAgentByIdNumbr(idn);
        String res = result.getPhoneNumber();

        assertEquals(expected, res);

    }
}
