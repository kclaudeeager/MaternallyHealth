package com.DU.api.repository;

import java.util.List;

import com.DU.api.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository  extends JpaRepository<consultation, Long> {
    @Query("SELECT c FROM consultation c WHERE c.id =?1")
   consultation findByConsultionId(Long consultionId);
   @Query("SELECT c FROM consultation c WHERE c.patientType=?1")
   List<consultation> findBypatientType(String patientType);
   @Query("SELECT c FROM consultation c WHERE c.patientId=?1")
   List<consultation> findBypatientId(Integer patientId);
   @Query("SELECT c FROM consultation c WHERE c.consulterId=?1")
   List<consultation> findByConsulterId(Integer consulterId);
   
    // @Query("SELECT b.branchname,b.phoneNumber,b.address FROM branch b WHERE b.branchname=?1")
    // List<String> findBranchByName(String branchname);

    // @Query("SELECT b.branchname,b.phoneNumber,b.address FROM branch b ")
    // List<Object> findAllBranch();

    // @Query("SELECT b FROM branch b WHERE b.branchname=?1")
    // Hospital findBranch(String branchname);

    // @Query("SELECT b.branchname,b.phoneNumber FROM branch b WHERE b.address=?1")
    // List<Object> findbranchBydistrict(String district);

    // public List<Object[]> findProjects();
}

    
