package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.DU.api.exception.AuthException;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.staff;
import com.DU.api.model.User;
import com.DU.api.service.LogsService;
import com.DU.api.repository.StaffRepository;

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
@Hidden
@RequestMapping("/api/v1")
public class StaffController {
  @Autowired
  private StaffRepository staffRepository;

  @Autowired
  LogsService logsService;
  Logger log = LoggerFactory.getLogger(StaffController.class);
  User user;

  @Operation(summary = "This is to add new staff to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "add new staff to the  Database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @PostMapping("/staffs")
  public staff createStaff(HttpServletRequest request, @Valid @RequestBody staff staff) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    String useremail = request.getAttribute("email").toString();
    if (i == 4) {
      String activity = "created new staff";
      logsService.savelog(useremail, activity);
      log.info("{} Created new staff ", useremail);
      return staffRepository.save(staff);
    } else {
      log.warn("{} Tried Create new staff but was not authorised ", useremail);
      throw new AuthException("Only admin can create a new staff :: ");
    }

  }

  @Operation(summary = "This is to fetch all staff to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "fetch all staff from the  Database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @GetMapping("/staffs")
  public List<staff> getAllStaffs(HttpServletRequest request) {
    String role = request.getAttribute("role").toString();
    String email = request.getAttribute("email").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    if (i == 4) {

      String activity = "veiwed all  staffs details";

      logsService.savelog(email, activity);
      return staffRepository.findAll();
    } else {
      throw new AuthException("Only admin and  can view staff data :: ");
    }
  }

  @Operation(summary = "This is to fetch staff by email from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "fetch staff by email from the  Database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @GetMapping("/staffs/{email}")
  public ResponseEntity<staff> getStaffByEmail(HttpServletRequest request,
      @PathVariable(value = "email") String email) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    if (i == 4) {
      String useremail = request.getAttribute("email").toString();
      staff staff = staffRepository.findStaffByEmail(email);
      String activity;
      if (staff == null) {
        throw new ResourceNotFoundException("staff not found :: " + email);
        // System.out.println(("staff not found :: " + email));
      }
      activity = "veiwed staff: " + email;
      logsService.savelog(useremail, activity);
      return ResponseEntity.ok().body(staff);
    } else {
      throw new AuthException("Only admin and  can view staff data :: ");
    }
  }

  @Operation(summary = "This is to delelte  staff from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "delete  staff from the  Database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @DeleteMapping("/staffs")
  public Map<String, Boolean> deletStafF(HttpServletRequest request, @RequestBody String email) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    if (i == 4) {
      staff staff = staffRepository.findStaffByEmail(email);
      String useremail = request.getAttribute("email").toString();
      if (staff == null) {
        throw new ResourceNotFoundException("staff  not found :: " + email);
      }
      staffRepository.delete(staff);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      String activity = "deleted staff: " + email;
      logsService.savelog(useremail, activity);
      return response;
    } else {
      throw new AuthException("Only admin and  can delete staff data :: ");
    }
  }

  @Operation(summary = "This is to update staff to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update staff to the  Database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @PutMapping("/staffs")
  public ResponseEntity<staff> updateStaff(HttpServletRequest request,
      @Valid @RequestBody staff staffDetails) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    if (i == 4) {

      staff staff = staffRepository.findStaffByEmail(staffDetails.getEmail());
      String useremail = request.getAttribute("email").toString();
      if (staff == null) {
        throw new ResourceNotFoundException("staff  not found :: " + staffDetails.getEmail());
      }
      staff.setEmail(staffDetails.getEmail());
      staff.setPhoneNumber(staffDetails.getPhoneNumber());
      staff.setFirstName(staffDetails.getFirstName());
      staff.setLastName(staffDetails.getLastName());
      staff.setTittle(staffDetails.gettitle());
      staff.setidnumber(staffDetails.getidnumber());
      staff.setresidance(staffDetails.getresidance());
      staff.setidtype(staffDetails.getidtype());
      staff.setworkingDays(staffDetails.getworkingDays());
      final staff updatedsStaff = staffRepository.save(staff);
      String activity = "updated staff: " + staffDetails.getEmail();
      logsService.savelog(useremail, activity);
      return ResponseEntity.ok(updatedsStaff);
    } else {
      throw new AuthException("Only admin and  can update staff data :: ");
    }
  }
}
