package com.DU.api.repository;

import com.DU.api.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findById(Integer id);
    @Query("SELECT d FROM Department d WHERE d.id =?1")
    Department findByDepartmentId(Long departmentId);
}
