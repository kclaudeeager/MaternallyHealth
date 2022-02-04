package com.DU.api.repository;

import static org.junit.Assert.assertEquals;

import com.DU.api.model.agents;
import com.DU.api.model.branch;
import com.DU.api.model.client;

//import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepo;

    @Test
    void testFindclientByEmail() {
        // String firstName, String email, String lastName, String phoneNumber, String
        // idtype, String idnumber,
        // String occupation, String residance, String accountnumber

        client testClient = new client("clientfname", "client@du.com", "clientlname", "078867382", "NID",
                "19928237827329",
                "farmer", "kicukiro", "400347439987394", 0);

        clientRepo.save(testClient);
        boolean expected = true;
        boolean res;
        String email = "client@du.com";
        client result = clientRepo.findclientByEmail(email);
        if (result != null) {
            res = true;
        } else {
            res = false;
        }

        assertEquals(expected, res);

    }
}
