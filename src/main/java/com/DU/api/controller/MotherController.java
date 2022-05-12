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
@RequestMapping("/api/v1/mothers")
public class MotherController {

    @Autowired
    private MotherRepository motherRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(MotherController.class);
    User user;

    @Operation(summary = "This is to add new mother to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new mother to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public Mother createMother(HttpServletRequest request, @Valid @RequestBody Mother mother) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN")) {
            String activity = "Register new mother";
            logsService.savelog(useremail, activity);
            log.info("{} Registered new mother ", useremail);
             mother.setRegisterId(Integer.parseInt(request.getAttribute("userId").toString()));
            return motherRepository.save(mother);
        } else {
            log.warn("{} Tried Create new mother but was not authorised ", useremail);
            throw new AuthException("Only nurse, doctor or admin can register new mother :: ");
        }

    }

    @Operation(summary = "This is to fetch all mothers from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all mothers from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<Mother> getAllMothers(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")) {

            String activity = "veiwed all  mothers details";

            logsService.savelog(email, activity);
            return motherRepository.findAll();
        } else {
            throw new AuthException("Only nurse, doctor or admin  can view mother details data :: ");
        }
    }

    @Operation(summary = "This is to delte  mother from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  mother from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete")
    public Map<String, Boolean> deleteMother(HttpServletRequest request, @RequestBody Map<String, String> phoneNumMap) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("ADMIN")) {
            Mother mother = motherRepository.findMotherByPhoneNumber(phoneNumMap.get("phone"));
            String useremail = request.getAttribute("email").toString();
            if (mother == null) {
                throw new ResourceNotFoundException(
                        "mother with such phone number :: " + phoneNumMap.get("phone") + "  not found ");
            }
            motherRepository.delete(mother);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted mother: " + phoneNumMap.get("phone");
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only admin and  can delete mother data :: ");
        }
    }

    @Operation(summary = "This is to update mother to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update mother to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update")
    public ResponseEntity<Mother> updateMother(HttpServletRequest request,
            @Valid @RequestBody Mother motherDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")) {
            Mother mother = motherRepository.findMotherByPhoneNumber(motherDetails.getPhoneNumber());
            String useremail = request.getAttribute("email").toString();
            if (mother == null) {
                throw new ResourceNotFoundException("mother  not found :: " + motherDetails.getPhoneNumber());
            }
            mother.setEmail(motherDetails.getEmail());
            mother.setPhoneNumber(motherDetails.getPhoneNumber());
            mother.setFirstName(motherDetails.getFirstName());
            mother.setLastName(motherDetails.getLastName());
            final Mother updatedMother = motherRepository.save(mother);
            String activity = "updated mother: " + motherDetails.getPhoneNumber();
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedMother);
        } else {
            throw new AuthException("Only admin and  can update mother data :: ");
        }
    }

    @Operation(summary = "This is to fetch mother by phone number from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch mother by phone from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/phone")
    public ResponseEntity<Mother> getMotherByMotherPhone(HttpServletRequest request,
            @Valid @RequestBody Map<String, String> phoneNumParameters) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")
                || role.equals("MOTHER")) {
            String useremail = request.getAttribute("email").toString();
            // staff staff = staffRepository.findStaffByEmail(email);
            //Integer userId = Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));
            Mother mother = motherRepository.findMotherByPhoneNumber(phoneNumParameters.get("phone"));
            String activity;
            if (mother == null) {
                throw new ResourceNotFoundException("Mother not found :: " + phoneNumParameters.get("phone"));
                // System.out.println(("staff not found :: " + email));
            }
            activity = "veiwed mother of mother with phone: " + phoneNumParameters.get("phone");
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok().body(mother);
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother  can view mothers data :: ");
        }
    }

}
