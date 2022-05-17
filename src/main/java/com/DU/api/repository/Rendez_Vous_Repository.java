package com.DU.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.DU.api.model.Mother;
import com.DU.api.model.Rendez_vous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rendez_Vous_Repository extends JpaRepository<Rendez_vous, Long> {
    @Query("SELECT r FROM Rendez_vous r WHERE r.id=?1")
    Rendez_vous findRendezvousById(Long id);
    @Query("SELECT r FROM Rendez_vous r WHERE r.mother_id=?1")
    List<Rendez_vous> findAllByMotherId(Long mother_id);
    @Query("SELECT r FROM Rendez_vous r WHERE r.hospitalId=?1")
    List<Rendez_vous> findAllByHospitallId(Long hospitalId);
    @Query("SELECT r FROM Rendez_vous r WHERE r.feedback=?1")
    List<Rendez_vous> findAllByFeedback(String feedback);


}