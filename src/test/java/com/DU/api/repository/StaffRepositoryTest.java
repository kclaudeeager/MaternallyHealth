package com.DU.api.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.DU.api.model.staff;

//import com.DU.api.repository.AgentsRepository;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class StaffRepositoryTest {
    @Autowired
    private StaffRepository staffRepo;

    @Test
    void testFindStaffByEmail() {

        staff testsStaff = new staff("staff@du.com", "stafffname", "stafflname", "07858565", "passport", "19974938420",
                "cashier", "nyarugenge", "all weekdays");

        staffRepo.save(testsStaff);
        boolean expected = true;
        boolean res;
        String email = "staff@du.com";
        staff result = staffRepo.findStaffByEmail(email);
        if (result != null) {
            res = true;
        } else {
            res = false;
        }

        assertEquals(expected, res);

    }
}