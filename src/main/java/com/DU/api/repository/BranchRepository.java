package com.DU.api.repository;

import java.util.List;

import com.DU.api.model.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<branch, Long> {
    branch findById(String branchId);

    @Query("SELECT b FROM branch b WHERE b.branchname=?1")
    branch findBranchByName(String branchname);

    @Query("SELECT b.branchname,b.phoneNumber FROM branch b ")
    List<Object> findAllBranch();

    // public List<Object[]> findProjects();
}
