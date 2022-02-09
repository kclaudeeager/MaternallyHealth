package com.DU.api.repository;

import com.DU.api.model.agents;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentsRepository extends JpaRepository<agents, Long> {
    agents findById(String agentId);

    @Query("SELECT a.firstName,a.lastName,a.phoneNumber FROM agents a WHERE a.idnumber=?1")
    List<Object> findAgentByIdNumber(String idnumber);

    @Query("SELECT a FROM agents a WHERE a.idnumber=?1")
    agents findAgentByIdNumbr(String idnumber);

    @Query("SELECT a.firstName,a.lastName,a.phoneNumber FROM agents a WHERE a.residance=?1")
    List<Object> findAgentBylocation(String location);
}
