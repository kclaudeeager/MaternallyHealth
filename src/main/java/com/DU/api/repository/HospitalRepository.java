package com.DU.api.repository;

import java.util.List;

import com.DU.api.model.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findById(Integer hosipitalId);

    @Query("SELECT h FROM Hospital h WHERE h.phoneNumber =?1")
    Hospital findHospitalByPhoneNumber(String hospitalPhoneNumber);
     
    @Query("SELECT h FROM Hospital h WHERE h.hospitalname=?1")
    Hospital findHospitalByName(String hospitalName);
    // @Query("SELECT b.branchname,b.phoneNumber,b.address FROM branch b WHERE
    // b.branchname=?1")
    // List<String> findBranchByName(String branchname);

    // @Query("SELECT b.branchname,b.phoneNumber,b.address FROM branch b ")
    // List<Object> findAllBranch();

    // @Query("SELECT b FROM branch b WHERE b.branchname=?1")
    // Hospital findBranch(String branchname);

    // @Query("SELECT b.branchname,b.phoneNumber FROM branch b WHERE b.address=?1")
    // List<Object> findbranchBydistrict(String district);

    // public List<Object[]> findProjects();
}
