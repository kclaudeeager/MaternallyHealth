package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.ArrayList;
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
@RequestMapping("/api/v1/DoctorAdvise")
public class DoctorAdviseController {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private DoctorAdviceRepository doctorAdviceRepository;
    @Autowired
    private MotherRepository motherRepository;
    Logger log = LoggerFactory.getLogger(DoctorAdviseController.class);
    User user;
    @Autowired
    private StaffRepository staffRepository;
    private @Valid staff staff;
    Hospital hospital;
    private HttpServletRequest request;
    private @Valid DOctorAdvise doctorAdvise;

    @Operation(summary = "This is to add new doctor advise to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new doctor advise to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public DOctorAdvise createDoctorAdvise(HttpServletRequest request,
            @Valid @RequestBody DOctorAdvise doctorAdvise) throws NotFoundException {
        this.request = request;
        this.doctorAdvise = doctorAdvise;
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        System.out.println("Doctor advise " + doctorAdvise.toString());
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN") || role.equals("DOCTOR") || role.equals("NURSE")) {
            String activity = "Register new doctor advise";
            logsService.savelog(useremail, activity);
            // System.out.println("Healthadvisor hospital id is
            // long:"+healthAdvisor.getHospital_id());
            Hospital hospital = hospitalRepository.findByHospitalId((doctorAdvise.getHospitalId()));
            // Integer userId=Integer.parseInt(request.getParameter("userId").toString());
            Mother mother = motherRepository.findByMotherId((doctorAdvise.getMotherId()));
            if (mother == null)
                throw new ResourceNotFoundException("Mother  not found  with such id:: " + doctorAdvise.getMotherId());

            if (hospital == null)
                throw new NotFoundException("Hospital not found with id " + doctorAdvise.getHospitalId());
            log.info("{} Registered new doctor advise ", useremail);
            doctorAdvise.setCreatedBy(request.getAttribute("userId").toString());
            return doctorAdviceRepository.save(doctorAdvise);
        } else {
            log.warn("{} Tried Create new doctor advise but was not authorised ", useremail);
            throw new AuthException(" Only authorized can register new doctor advise :: ");
        }

    }

    @Operation(summary = "This is to fetch all doctor advises from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all HealthAdvisor from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<DOctorAdvise> getAllHealthAdvisors(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST")) {

            String activity = "veiwed all  doctor advices details";

            logsService.savelog(email, activity);
            return doctorAdviceRepository.findAll();
        } else {
            throw new AuthException("Only users with roles can view all doctor advices details data :: ");

        }
    }

    @Operation(summary = "This is to delte  doctor advise from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  doctor advise from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete/{adviceId}")
    public Map<String, Boolean> deleteHealthAdvisor(HttpServletRequest request,
            @PathVariable(value = "adviceId") String adviceId) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();

        staff staff = staffRepository.findStaffByEmail(useremail);
        DOctorAdvise doctorAdvise = doctorAdviceRepository.findByAdviceId(Integer.parseInt(adviceId));
        if (doctorAdvise == null)
            throw new ResourceNotFoundException(
                    "doctor advise such id :: " + adviceId + "  not found ");
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
                || doctorAdvise.getCreatedBy().equals(staff.getId())) {

            doctorAdviceRepository.delete(doctorAdvise);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted doctor advise: " + adviceId;
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only authorized users and  can delete doctor advise data :: ");
        }
    }

    @Operation(summary = "This is to update Doctor advise to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update Doctor advise to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{adviceId}")
    public ResponseEntity<DOctorAdvise> updatedhealthAdvisor(HttpServletRequest request,
            @PathVariable(value = "adviceId") String adviceId,
            @Valid @RequestBody DOctorAdvise doctorAdviseDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        String useremail = request.getAttribute("email").toString();

        staff staff = staffRepository.findStaffByEmail(useremail);
        DOctorAdvise doctorAdvise = doctorAdviceRepository.findByAdviceId(Integer.parseInt(adviceId));
        if (doctorAdvise == null)
            throw new ResourceNotFoundException(
                    "doctor advise such id :: " + adviceId + "  not found ");
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
                || doctorAdvise.getCreatedBy().equals(staff.getId())) {

            doctorAdvise.setAdvise(doctorAdviseDetails.getAdvise() == null ? doctorAdvise.getAdvise()
                    : doctorAdviseDetails.getAdvise());
            doctorAdvise.setMotherId(doctorAdviseDetails.getMotherId() == null ? doctorAdvise.getMotherId()
                    : doctorAdviseDetails.getMotherId());
            final DOctorAdvise updatedDOctorAdvise = doctorAdviceRepository.save(doctorAdvise);
            String activity = "updated doctorAdvise: " + adviceId;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedDOctorAdvise);
        } else {
            throw new AuthException("Only admins and  can update doctor advise data :: ");
        }
    }

    @Operation(summary = "This is to fetch hospital by phone number from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch hospital by phone from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/motherAdvises/{phoneNumber}")
    public List<DOctorAdvise> getAdviseByMotherPhoneNumber(HttpServletRequest request,
            @PathVariable("phoneNumber") String phoneNumber) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        Mother mother = motherRepository.findMotherByPhoneNumber(phoneNumber);
        String useremail = request.getAttribute("email").toString();
        String activity;
        if (mother == null) {
            throw new ResourceNotFoundException("mother with such phone not found :: " + phoneNumber);
            // System.out.println(("staff not found :: " + email));
        }
        System.out.println("<<<<<<<>>>>>>"+mother.getPhoneNumber());
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST")
                || role.equals("HOSPITAL_ADMIN") || mother.getEmail().equals(useremail)) {

            // staff staff = staffRepository.findStaffByEmail(email);
            // Integer userId =
            // Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));

            activity = "veiwed doctor advise with name: " + phoneNumber;

            logsService.savelog(useremail, activity);
            List<DOctorAdvise> doctorAdvises = new ArrayList();
            System.out.println("mother id "+mother.getId());
            doctorAdvises.addAll(doctorAdviceRepository.findAllByMotherId(mother.getId()));
             System.out.println("Adivises: " + doctorAdvises);
            return doctorAdvises ;
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother can view doctorAdvise data :: ");
        }
    }

}
