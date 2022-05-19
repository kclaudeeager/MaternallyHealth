package com.DU.api.repository;

import java.util.List;

import com.DU.api.model.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<staff, Long> {
    staff findById(String staffId);

    @Query("SELECT s FROM staff s WHERE s.email=?1")
    staff findStaffByEmail(String emailAddress);
    @Query("SELECT s FROM staff s WHERE s.id=?1")
    staff findByStaffId(Long stuff_id);
    @Query("SELECT s FROM staff s WHERE s.hospitalId=?1")
    List<staff> findStaffsByHospitalId(Long hospitalId);
    @Query("SELECT s FROM staff s WHERE s.departmentId=?1")
    List<staff> findStaffsByDepartmentId(Long departmentId); //(String departmentId);
    
  
}
