
package com.DU.api.repository;

import static org.junit.Assert.assertEquals;

import com.DU.api.model.agents;
import com.DU.api.model.branch;

//import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BranchRepositoryTest {
    @Autowired
    private BranchRepository branchRepo;

    @Test
    void testFindBranchByName() {
        // String address, String openingHour, String closingHour, String branchname,
        // String staffNumber, String branchManager, String phoneNumber)
        branch testbranch = new branch("remera", "8am", "9pm", "Kisimenti", "32",
                "mugabo", "0789378");

        branchRepo.save(testbranch);
        boolean expected = true;
        boolean res;
        String branchname = "Kisimenti";
        branch result = branchRepo.findBranch(branchname);
        if (result != null) {
            res = true;
        } else {
            res = false;
        }

        assertEquals(expected, res);

    }
}