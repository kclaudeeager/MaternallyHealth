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

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(StaffController.class);
    User user;
    Hospital hospital;

    @Operation(summary = "This is to add new hospital to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new hospital to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public Hospital createHospital(HttpServletRequest request, @Valid @RequestBody Hospital hospital) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (role.equals("ADMIN")) {
            String activity = "Register new hospital";
            logsService.savelog(useremail, activity);
            log.info("{} Registered new hospital ", useremail);

            return hospitalRepository.save(hospital);
        } else {
            log.warn("{} Tried Create new hospital but was not authorised ", useremail);
            throw new AuthException("admin can register new hospital :: ");
        }

    }

    @Operation(summary = "This is to fetch all hospitals from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all hospitals from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<Hospital> getAllHospitals(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        // if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
        // role.equals("RECEPTIONIST")) {

        String activity = "veiwed all  hospitals details";

        logsService.savelog(email, activity);
        return hospitalRepository.findAll();
        // } else {
        // throw new AuthException("Only nurse, doctor or admin can view mother details
        // data :: ");
        // }
    }

    @Operation(summary = "This is to delte  hospital from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  hospital from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete")
    public Map<String, Boolean> deleteHospital(HttpServletRequest request,
            @RequestBody Map<String, String> phoneNumMap) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("ADMIN")) {
            Hospital hospital = hospitalRepository.findHospitalByPhoneNumber(phoneNumMap.get("phone"));
            String useremail = request.getAttribute("email").toString();
            if (hospital == null) {
                throw new ResourceNotFoundException(
                        "Hospital with such phone number :: " + phoneNumMap.get("phone") + "  not found ");
            }
            hospitalRepository.delete(hospital);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted hospital: " + phoneNumMap.get("phone");
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only admin and  can delete hospital data :: ");
        }
    }

    @Operation(summary = "This is to update hospital to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update mother to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{hospitalName}")
    public ResponseEntity<Hospital> updateMother(HttpServletRequest request,
            @PathVariable(value = "hospitalName") String hospitalName,
            @Valid @RequestBody Hospital hospitalDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")) {
            Hospital hospital = hospitalRepository.findHospitalByName(hospitalName);
            String useremail = request.getAttribute("email").toString();
            if (hospital == null) {
                throw new ResourceNotFoundException("hospital  not found :: " + hospitalDetails.getphoneNumbe());
            }
            hospital.setphoneNumber(hospitalDetails.getphoneNumbe() == null ? hospital.getphoneNumbe()
                    : String.valueOf(hospitalDetails.getphoneNumbe()));
            hospital.sethospitalAdmin(hospitalDetails.gethospitalAdmin() == null ? hospital.gethospitalAdmin()
                    : hospitalDetails.gethospitalAdmin());
            hospital.setlocation(
                    hospitalDetails.getlocation() == null ? hospital.getlocation() : hospitalDetails.getlocation());
            hospital.sethospitalname(hospitalDetails.gethospitalname() == null ? hospital.gethospitalname()
                    : hospitalDetails.gethospitalname());

            final Hospital updatedHospital = hospitalRepository.save(hospital);
            String activity = "updated hospital: " + hospitalName;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedHospital);
        } else {
            throw new AuthException("Only admin and  can update hospital data :: ");
        }
    }

    @Operation(summary = "This is to fetch hospital by phone number from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch hospital by phone from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/name")
    public ResponseEntity<Hospital> getMotherByMotherPhone(HttpServletRequest request,
            @Valid @RequestBody Map<String, String> nameParameters) {
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
        Hospital hospital = hospitalRepository.findHospitalByName(nameParameters.get("hospitalName"));
        String activity;
        if (hospital == null) {
            throw new ResourceNotFoundException("Hospital not found :: " + nameParameters.get("hospitalName"));
            // System.out.println(("staff not found :: " + email));
        }
        activity = "veiwed hospital with name: " + nameParameters.get("hospitalName");
        logsService.savelog(useremail, activity);
        return ResponseEntity.ok().body(hospital);
        // } else {
        // throw new AuthException("Only nurse, doctor or admin or mother can view
        // mothers data :: ");
        // }
    }

}
