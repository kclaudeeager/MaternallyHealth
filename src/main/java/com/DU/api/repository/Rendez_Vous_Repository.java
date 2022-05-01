package com.DU.api.repository;

import javax.transaction.Transactional;

import com.DU.api.model.Mother;
import com.DU.api.model.Rendez_vous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rendez_Vous_Repository extends JpaRepository<Rendez_vous, Long> {
    Mother findById(Integer motherID);

//@Query("SELECT c FROM client c WHERE c.email=?1")
   // Mother findMotherByEmail(String emailAddress);

    // @Query("SELECT c FROM client c WHERE c.idnumber=?1")
    // Mother findclientByIdnumber(String idnumber);

    // @Query("SELECT c FROM client c WHERE c.phoneNumber =?1")
    // Mother findclientByPhoneNumber(String phoneNumber);

    // @Transactional
    // @Modifying
    // @Query("update client c set c.balance =?1 where c.idnumber =?2")
    // void setbalanceForClient(Integer amount, String idnumber);

    // @Transactional
    // @Modifying
    // @Query("update client c set c.balance = ?1 where c.accountnumber = ?2")
    // void setbalanceForClientByAccount(Integer amount, String accountnumber);

    // @Transactional
    // @Modifying
    // @Query("update client c set c.balance =?1 where c.phoneNumber =?2")
    // void setbalanceForClientByPhonenumber(Integer amount, String phonenumber)
}