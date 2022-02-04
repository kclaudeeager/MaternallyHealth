package com.DU.api.repository;

import com.DU.api.model.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<staff, Long> {
    staff findById(String staffId);

    @Query("SELECT s FROM staff s WHERE s.email=?1")
    staff findStaffByEmail(String emailAddress);
}
