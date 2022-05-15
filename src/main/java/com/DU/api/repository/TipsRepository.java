package com.DU.api.repository;
import java.util.List;

import javax.transaction.Transactional;

import com.DU.api.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<Tips,Long> {
    @Query("SELECT t FROM Tips t WHERE t.tip_name =?1")
    List<Tips> getTipsByName(String tipName);
    @Query("SELECT t FROM Tips t WHERE t.id =?1")
    Tips findByTipId(Long tipId);
  

}
