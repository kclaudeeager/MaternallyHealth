package com.DU.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DU.api.model.Plate;

@Repository
public interface plateRepository extends JpaRepository<Plate, Long> {
	Plate findById(String Id);
}