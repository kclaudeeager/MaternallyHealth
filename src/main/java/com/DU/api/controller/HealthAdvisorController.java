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
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v1/HealthAdvisor")
public class HealthAdvisorController {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private HealthAdvisorRepository healthAdvisorRepository;
    Logger log = LoggerFactory.getLogger(HealthAdvisorController.class);
    User user;
    Hospital hospital;

    @Operation(summary = "This is to add new Health advisor to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new Health advisor to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public HealthAdvisor createHealthAdvisor(HttpServletRequest request,
            @Valid @RequestBody HealthAdvisor healthAdvisor) throws NotFoundException {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")) {
            String activity = "Register new Health advisor";
            logsService.savelog(useremail, activity);
            System.out.println("Healthadvisor hospital id is long:"+healthAdvisor.getHospital_id());
            Hospital hospital = hospitalRepository.findByHospitalId((healthAdvisor.getHospital_id()));
            // Integer userId=Integer.parseInt(request.getParameter("userId").toString());

            if (hospital == null)
                throw new NotFoundException("Hospital not found with id " + healthAdvisor.getHospital_id());
            log.info("{} Registered new Health advisor ", useremail);
            return healthAdvisorRepository.save(healthAdvisor);
        } else {
            log.warn("{} Tried Create new HealthAdvisor but was not authorised ", useremail);
            throw new AuthException("admins can register new health advisor :: ");
        }

    }

    @Operation(summary = "This is to fetch all HealthAdvisor from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all HealthAdvisor from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<HealthAdvisor> getAllHealthAdvisors(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        // if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
        // role.equals("RECEPTIONIST")) {

        String activity = "veiwed all  HealthAdvisor details";

        logsService.savelog(email, activity);
        return healthAdvisorRepository.findAll();
        // } else {
        // throw new AuthException("Only nurse, doctor or admin can view mother details
        // data :: ");
        // }
    }

    @Operation(summary = "This is to delte  HealthAdvisor from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  HealthAdvisor from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete/{healthAdvisorPhoneNum}")
    public Map<String, Boolean> deleteHealthAdvisor(HttpServletRequest request,
            @PathVariable(value = "healthAdvisorPhoneNum") String healthAdvisorPhoneNum) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")) {
            HealthAdvisor healthAdvisor = healthAdvisorRepository.findByPhoneNumber(healthAdvisorPhoneNum);
            String useremail = request.getAttribute("email").toString();
            if (healthAdvisor == null) {
                throw new ResourceNotFoundException(
                        "Health Monitorwith such phone number :: " + healthAdvisorPhoneNum + "  not found ");
            }
            healthAdvisorRepository.delete(healthAdvisor);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted hospital: " + healthAdvisorPhoneNum;
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only admins and  can delete healthAdvisorPhoneNum data :: ");
        }
    }

    @Operation(summary = "This is to update HealthAdvisor to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update HealthAdvisor to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{healthAdvisorPhoneNum}")
    public ResponseEntity<HealthAdvisor> updatedhealthAdvisor(HttpServletRequest request,
            @PathVariable(value = "healthAdvisorPhoneNum") String healthAdvisorPhoneNum,
            @Valid @RequestBody HealthAdvisor healthAdvisorDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")) {
            HealthAdvisor healthAdvisor = healthAdvisorRepository.findByPhoneNumber(healthAdvisorPhoneNum);
            String useremail = request.getAttribute("email").toString();
            if (healthAdvisor == null) {
                throw new ResourceNotFoundException("HealthAdvisor  not found :: " + healthAdvisorPhoneNum);
            }
            healthAdvisor.setPhoneNumber(healthAdvisorDetails.getPhoneNumber() == null ? healthAdvisor.getPhoneNumber()
                    : healthAdvisorDetails.getPhoneNumber());
            healthAdvisor.setAge(
                    healthAdvisorDetails.getAge() == null ? healthAdvisor.getAge() : healthAdvisorDetails.getAge());
            healthAdvisor.setFirstName(healthAdvisorDetails.getFirstName() == null ? healthAdvisor.getFirstName()
                    : healthAdvisorDetails.getFirstName());
            healthAdvisor.setLastName(healthAdvisorDetails.getLastName() == null ? healthAdvisor.getLastName()
                    : healthAdvisorDetails.getLastName());
            healthAdvisor.setPhoneNumber(healthAdvisorDetails.getPhoneNumber() == null ? healthAdvisor.getPhoneNumber()
                    : healthAdvisorDetails.getPhoneNumber());
            healthAdvisor.setEmail(healthAdvisorDetails.getEmail() == null ? healthAdvisor.getEmail()
                    : healthAdvisorDetails.getEmail());
            healthAdvisor.setIdnumber(healthAdvisorDetails.getIdnumber() == null ? healthAdvisor.getIdnumber()
                    : healthAdvisorDetails.getIdnumber());
            healthAdvisor.setResidance(healthAdvisorDetails.getResidance() == null ? healthAdvisor.getResidance()
                    : healthAdvisorDetails.getResidance());
            healthAdvisor.setHospital_id(healthAdvisorDetails.getHospital_id() == null ? healthAdvisor.getHospital_id()
                    : healthAdvisorDetails.getHospital_id());
            final HealthAdvisor updatedhealthAdvisor = healthAdvisorRepository.save(healthAdvisor);
            String activity = "updated healthAdvisor: " + healthAdvisorPhoneNum;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedhealthAdvisor);
        } else {
            throw new AuthException("Only admins and  can update healthAdvisor data :: ");
        }
    }

    @Operation(summary = "This is to fetch hospital by phone number from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch hospital by phone from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/phoneNumber")
    public ResponseEntity<HealthAdvisor> getHealthAdvisorByPhone(HttpServletRequest request,
            @Valid @RequestBody Map<String, String> phoneNumMap) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        // if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
        // role.equals("RECEPTIONIST")
        // || role.equals("MOTHER")) {
        String useremail = request.getAttribute("email").toString();
        // staff staff = staffRepository.findStaffByEmail(email);
        // Integer userId =
        // Integer.parseInt(request.getAttribute("user_id").toString());
        // User user = userRepository.findByUserId(Integer.parseInt(motherId));
        HealthAdvisor healthAdvisor = healthAdvisorRepository.findByPhoneNumber(phoneNumMap.get("phone"));
        String activity;
        if (hospital == null) {
            throw new ResourceNotFoundException("healthAdvisor not found :: " + phoneNumMap.get("phone"));
            // System.out.println(("staff not found :: " + email));
        }
        activity = "veiwed healthAdvisor with name: " + phoneNumMap.get("phone");
        logsService.savelog(useremail, activity);
        return ResponseEntity.ok().body(healthAdvisor);
        // } else {
        // throw new AuthException("Only nurse, doctor or admin or mother can view
        // mothers data :: ");
        // }
    }

}
