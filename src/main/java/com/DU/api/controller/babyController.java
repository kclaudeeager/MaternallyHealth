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
@RequestMapping("/api/v1/Baby")
public class babyController {
    @Autowired
    private BabyRepository babyRepository;
    @Autowired
    private MotherRepository motherRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(babyController.class);
    User user;

    @Operation(summary = "This is to add new baby to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new baby to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public Baby createBaby(HttpServletRequest request, @Valid @RequestBody Baby baby) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN")) {
            String activity = "Register new baby";
            logsService.savelog(useremail, activity);
            log.info("{} Registered new baby ", useremail);
            // int motherId = (int) (baby.getMotherId().longValue());
            Mother mother = motherRepository.findByMotherId(baby.getMotherId());
            if (mother == null) {
                throw new ResourceNotFoundException("Mother not found :: " + baby.getId());
            }
            return babyRepository.save(baby);
        } else {
            log.warn("{} Tried Create new baby but was not authorised ", useremail);
            throw new AuthException("Only nurse, doctor or admin can register new baby :: ");
        }

    }

    @Operation(summary = "This is to fetch all babies from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all babies from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<Baby> getAllBabies(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")) {

            String activity = "veiwed all  babies details";

            logsService.savelog(email, activity);
            return babyRepository.findAll();
        } else {
            throw new AuthException("Only nurse, doctor or admin  can view babies data :: ");
        }
    }

    @Operation(summary = "This is to fetch all babies by mother id from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch babies by mother  from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/mother/{motherId}")
    public List<Baby> getBabiesByMotherId(HttpServletRequest request,
            @PathVariable(value = "motherId") Long motherId) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")
                || role.equals("MOTHER")) {
            String useremail = request.getAttribute("email").toString();
            // staff staff = staffRepository.findStaffByEmail(email);
            // Integer userId =
            // Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));
            Mother mother = motherRepository.findByMotherId(motherId);
            String activity;
            // if (mother == null) {
            // throw new ResourceNotFoundException("Mother not found :: " + motherId);
            // // System.out.println(("staff not found :: " + email));
            // }
            List<Baby> babies = babyRepository.getBabiesByMotherId(motherId);
            // if (babies == null) {
            // throw new ResourceNotFoundException("babies not found :: " + mother);
            // }
            activity = "veiwed babies of mother id: " + mother;
            logsService.savelog(useremail, activity);
            return babies;
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother  can view babies data :: ");
        }
    }

    @Operation(summary = "This is to fetch all babies by mother id from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch babies by mother  from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/hospital/{hospitalId}")
    public List<Baby> getBabiesByHospitalId(HttpServletRequest request,
            @PathVariable(value = "hospitalId") Long hospitalId) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")
                || role.equals("HOSPITAL_ADMIN")) {
            String useremail = request.getAttribute("email").toString();
            // staff staff = staffRepository.findStaffByEmail(email);
            // Integer userId =
            // Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));
            // Hos mother = motherRepository.findByMotherId(motherId);
            String activity;
            // if (mother == null) {
            // throw new ResourceNotFoundException("Mother not found :: " + motherId);
            // // System.out.println(("staff not found :: " + email));
            // }
            List<Baby> babies = babyRepository.getBabyByHospitalsId(hospitalId);
            // if (babies == null) {
            // throw new ResourceNotFoundException("babies not found :: " + mother);
            // }
            activity = "veiwed babies of hospitalId : " + hospitalId;
            logsService.savelog(useremail, activity);
            return babies;
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother  can view babies data :: ");
        }
    }

    @Operation(summary = "This is to delte  baby from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  baby from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete")
    public Map<String, Boolean> deleteBaby(HttpServletRequest request,
            @Valid @RequestBody Map<String, String> params) throws Exception {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("ADMIN")) {
            Baby baby = babyRepository.findById(params.get("childId"));
            String useremail = request.getAttribute("email").toString();
            if (baby == null) {
                throw new ResourceNotFoundException("baby  not found :: " + params.get("childId"));
            }
            babyRepository.delete(baby);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted baby: " + params.get("childId");
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only admin and  can delete mother data :: ");
        }
    }

    @Operation(summary = "This is to update baby to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update baby to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update")
    public ResponseEntity<Baby> updateBaby(HttpServletRequest request,
            @Valid @RequestBody Baby baby) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")) {
            String babyId = String.valueOf(baby.getId());
            Integer childId = Integer.parseInt(babyId);
            Baby child = babyRepository.findById(babyId);
            String useremail = request.getAttribute("email").toString();
            if (child == null) {
                throw new ResourceNotFoundException("child  not found :: " + baby);
            }
            child.setFirstName(baby.getFirstName());
            child.setLastName(baby.getLastName());
            child.setMotherId(baby.getMotherId());
            child.setWeight(baby.getWeight());
            child.setStatus(baby.getStatus());
            child.setHeight(baby.getHeight());

            final Baby updatedbaby = babyRepository.save(child);
            String activity = "updated baby: " + baby.getFirstName();
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedbaby);
        } else {
            throw new AuthException("Only admin and  can update baby data :: ");
        }
    }
}
