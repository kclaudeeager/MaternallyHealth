package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.DU.api.constants.Constants;
import com.DU.api.exception.AuthException;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.*;
import com.DU.api.repository.*;
import com.DU.api.service.LogsService;
import com.DU.api.service.UserService;

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
    @Autowired
    private HospitalRepository hospitalRepository;
    Logger log = LoggerFactory.getLogger(MotherController.class);
    User user;
    @Autowired
    UserService userService;
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
            
                System.out.println("Status: " + mother.getStatus());
             if(mother.getStatus()==null || mother.getStatus()==""){
                mother.setStatus(Constants.STATAS[0]);  
             }
          
            else{
                boolean success = false;
                for(String status : Constants.STATAS)
                   {
                     if(status.equals(mother.getStatus()))
                       success = true;
                   }
                   if(!success)
                      throw new IllegalStateException("Status must be in these types: " + Arrays.toString(Constants.STATAS));
            
            }
            //System.out.println("Mother status: "+mother.getStatus());
            Hospital hospital= hospitalRepository.findByHospitalId(mother.getHospitalId());
          
            if(hospital==null){
                throw new ResourceNotFoundException("no such hospital found for  id" + mother.getHospitalId());
            }
            else
            System.out.println("Hospital: "+hospital.toString());
            log.info("{} Registered new mother ", useremail);
            mother.setRegisterId(Long.parseLong(request.getAttribute("userId").toString()));
            User user=new User(mother.getFirstName(), mother.getLastName(), mother.getEmail(), mother.getPhoneNumber(),0);
            user.setRole("MOTHER");
             try {
                userService.registerUser(user);
            } catch (javax.security.auth.message.AuthException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
    @Operation(summary = "This is to fetch all mothers by hospitalName from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all mothers by hospitalName from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all/{hospitalName}")
    public List<Mother> getAllMothersByHospital(HttpServletRequest request,@PathVariable("hospitalName") String hospitalName) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")) {

            String activity = "veiwed all  mothers details by hospitalName";
           Hospital hospital= hospitalRepository.findHospitalByName(hospitalName);
           if(hospital == null)
              throw new ResourceNotFoundException(String.format("No such hospital found for {name}",hospitalName));
            
            logsService.savelog(email, activity);
            return motherRepository.findAllByHospitallId(hospital.getId());
        } else {
            throw new AuthException("Only nurse, doctor or admins  can view mother details data :: ");
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
        if (role.equals("ADMIN")||role.equals("DOCTOR") || role.equals("NURSE")) {
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

    @PutMapping("/update/{phoneNum}")
    public ResponseEntity<Mother> updateMother(HttpServletRequest request,@PathVariable("phoneNum") String phoneNum,
            @Valid @RequestBody Mother motherDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")||role.equals("DOCTOR") || role.equals("NURSE")) {
            Mother mother = motherRepository.findMotherByPhoneNumber(phoneNum);
            String useremail = request.getAttribute("email").toString();
            if (mother == null) {
                throw new ResourceNotFoundException("mother  not found :: " +phoneNum);
            }
            mother.setEmail(motherDetails.getEmail());
            mother.setPhoneNumber(motherDetails.getPhoneNumber()== null ? mother.getPhoneNumber():motherDetails.getPhoneNumber());
            mother.setFirstName(motherDetails.getFirstName()== null ? mother.getFirstName():motherDetails.getFirstName());
            mother.setLastName(motherDetails.getLastName()== null ? mother.getLastName():motherDetails.getLastName());
            mother.setStatus(motherDetails.getStatus()== null ? mother.getStatus():motherDetails.getStatus());
            mother.setResidance(motherDetails.getResidance()== null ? mother.getResidance():motherDetails.getResidance());
            final Mother updatedMother = motherRepository.save(mother);
            String activity = "updated mother: " +phoneNum;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedMother);
        } else {
            throw new AuthException("Only admin and  can update mother data :: ");
        }
    }
    @Operation(summary = "This is to update mother status to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update mother status to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/updateStatus/{phoneNumber}")
    public ResponseEntity<Mother> updateMotherStatus(HttpServletRequest request,@PathVariable("phoneNumber") String phoneNumber,
            @Valid @RequestBody Map<String, String>  statusParams) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")||role.equals("DOCTOR") || role.equals("NURSE")) {
            Mother mother = motherRepository.findMotherByPhoneNumber(phoneNumber);
            String useremail = request.getAttribute("email").toString();
            if (mother == null) {
                throw new ResourceNotFoundException("mother  not found :: " +phoneNumber);
            }
            mother.setStatus(statusParams.get("status"));
            final Mother updatedMother = motherRepository.save(mother);
            String activity = "updated mother: " + phoneNumber;
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

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Mother> getMotherByMotherPhone(HttpServletRequest request, @PathVariable("phoneNumber") String phoneNumber) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        Mother mother = motherRepository.findMotherByPhoneNumber(phoneNumber);
        if (mother == null) {
            throw new ResourceNotFoundException("Mother not found :: " + phoneNumber);
            // System.out.println(("staff not found :: " + email));
        }
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") || role.equals("RECEPTIONIST")
                ||useremail.equals(mother.getEmail())) {
            
            String activity;
        
            activity = "veiwed mother of mother with phone: " + phoneNumber;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok().body(mother);
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother  can view mothers data :: ");
        }
    }

}
