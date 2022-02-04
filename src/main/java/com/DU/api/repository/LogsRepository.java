package com.DU.api.repository;

import java.util.List;

import com.DU.api.model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {
    @Query("SELECT l FROM Logs l WHERE l.email=?1")
    List<Logs> findLogsByEmail(String emailAddress);
}