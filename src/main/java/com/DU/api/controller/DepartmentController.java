package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.DU.api.exception.AuthException;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.*;
import com.DU.api.repository.*;
import com.DU.api.service.LogsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private DepartmentRepository departmentRepository;
    Logger log = LoggerFactory.getLogger(DepartmentController.class);
    User user;
    Hospital hospital;

    @Operation(summary = "This is to add new Department to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new department to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public Department createDepartment(HttpServletRequest request, @Valid @RequestBody Department department) throws NotFoundException {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (role.equals("ADMIN")|| role.equals("HOSPITAL_ADMIN")) {
            String activity = "Register new Health advisor";
            logsService.savelog(useremail, activity);
            log.info("{} Registered new Health advisor ", useremail);
             Hospital hospital=hospitalRepository.findById((int)(department.getHospital_id()).longValue());
             Integer userId=Integer.parseInt(request.getParameter("userId").toString());
             
             if(hospital==null)
                throw new ResourceNotFoundException("Hospital not found with id " + department.getHospital_id());
            return departmentRepository.save(department);
        } else {
            log.warn("{} Tried Create new department but was not authorised ", useremail);
            throw new AuthException("admins can register new department :: ");
        }

    }

    @Operation(summary = "This is to fetch all departments from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all HealthAdvisor from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
     
    @GetMapping("/all")
    public List<Department> getAllDepartments(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        // if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
        // role.equals("RECEPTIONIST")) {

        String activity = "veiwed all  department details";

        logsService.savelog(email, activity);
        return departmentRepository.findAll();
        // } else {
        // throw new AuthException("Only nurse, doctor or admin can view mother details
        // data :: ");
        // }
    }

    @Operation(summary = "This is to delte  department from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  department from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete/{departmentId}")
    public Map<String, Boolean> deleteDepartment(HttpServletRequest request,
            @PathVariable(value = "departmentId") Integer departmentId) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("ADMIN")|| role.equals("HOSPITAL_ADMIN")) {
            Department department = departmentRepository.findById(departmentId);
            String useremail = request.getAttribute("email").toString();
            if (department == null) {
                throw new ResourceNotFoundException(
                        "department such id :: " + departmentId + "  not found ");
            }
           departmentRepository.delete(department);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted department: " + departmentId;
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only admins and  can delete department data :: ");
        }
    }

    @Operation(summary = "This is to update HealthAdvisor to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update HealthAdvisor to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{departmentId}")
    public ResponseEntity<Department> updateDepartment(HttpServletRequest request,
            @PathVariable(value = "departmentId") Integer departmentId,
            @Valid @RequestBody Department departmentDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")|| role.equals("HOSPITAL_ADMIN")) {
            Department department = departmentRepository.findById(departmentId);
            String useremail = request.getAttribute("email").toString();
            if (department == null) {
                throw new ResourceNotFoundException(
                        "department such id :: " + departmentId + "  not found ");
            }
            department.setDepartment_name(departmentDetails.getDepartment_name()== null?department.getDepartment_name():departmentDetails.getDepartment_name());

              
            final Department updatedDepartment = departmentRepository.save(department);
            String activity = "updated department: " + departmentId;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedDepartment);
        } else {
            throw new AuthException("Only admins and  can update hospital data :: ");
        }
    }


}

