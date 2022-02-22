package com.DU.api.repository;

import javax.transaction.Transactional;

import com.DU.api.model.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<client, Long> {
    client findById(String clientId);

    @Query("SELECT c FROM client c WHERE c.email=?1")
    client findclientByEmail(String emailAddress);

    @Query("SELECT c FROM client c WHERE c.idnumber=?1")
    client findclientByIdnumber(String idnumber);

    @Query("SELECT c FROM client c WHERE c.accountnumber=?1")
    client findclientByAccount(String accountnumber);

    @Query("SELECT c FROM client c WHERE c.phoneNumber =?1")
    client findclientByPhoneNumber(String phoneNumber);

    @Transactional
    @Modifying
    @Query("update client c set c.balaance=?1 where c.idnumber=?2")
    void setbalanceForClient(Integer amount, String idnumber);

    // @Transactional
    // @Modifying
    // @Query("update client c set c.balance = ?1 where c.accountnumber = ?2")
    // void setbalanceForClientByAccount(Integer amount, String accountnumber);

    @Transactional
    @Modifying
    @Query("update client c set c.balance =?1 where c.phoneNumber =?2")
    void setbalanceForClientByPhonenumber(Integer amount, String phonenumber);

}