package com.DU.api.repository;

import com.DU.api.model.agents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentsRepository extends JpaRepository<agents, Long> {
    agents findById(String agentId);

    @Query("SELECT a FROM agents a WHERE a.idnumber=?1")
    agents findAgentByIdNumber(String idnumber);
}
