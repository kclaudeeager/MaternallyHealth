package com.DU.api.controller;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.DU.api.constants.Constants;
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
@RequestMapping("/api/v1/HealthTips")
public class TipsController {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    HealthAdvisorRepository healthAdvisorRepository;
    @Autowired
    private TipsRepository tipsRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(babyController.class);
    User user;

    @Operation(summary = "This is to add new health tip to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new health tip to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public Tips CreateTips(HttpServletRequest request, @Valid @RequestBody Tips tip) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String userId= request.getAttribute("userId").toString();
        System.out.println("Id is "+userId);
        String useremail = request.getAttribute("email").toString();
        if(role == null)
         {
            log.warn("{} Tried Create new health tip but was not authorised ", useremail);
             throw new AuthException("Only users with roles can add new health tip to the  Database");
        }

        if (role.equals("NONE") || role.equals("MOTHER")|| role.equals("RECEPTIONIST")) 
            {
                log.warn("{} Tried Create new health tip but was not authorised ", useremail);
                throw new AuthException("Only nurse, doctor or admins or healthAdvisor can create new health tip");
            }
            else{

            String activity = "Create new tip";
            logsService.savelog(useremail, activity);
            log.info("{}Created new tip ", useremail);
            if(tip.getTip_name()!= null){
                boolean expected = false;
              for(String tipName:Constants.TIP_NAMES){
                 if(tipName.equals(tip.getTip_name())){
                     expected = true;
                 }
            }
            if(!expected)
            throw new IllegalStateException("the tip name should be in the following set of attributes: "+Arrays.toString(Constants.TIP_NAMES));
            }
          
              tip.setCreatedBy(Integer.parseInt(userId));
            return tipsRepository.save(tip);
        } 

    }

    @Operation(summary = "This is to fetch all tips from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all tips from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<Tips> getAllTips(HttpServletRequest request) {
        //String role = request.getAttribute("role").toString();
        //String email = request.getAttribute("email").toString();
       // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
     
            // String activity = "veiwed all  tips details";

            // logsService.savelog(email, activity);
            return tipsRepository.findAll();
        } 

    @Operation(summary = "This is to fetch tips by tip name from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch tips tip name from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/{tipName}")
    public List<Tips> getAllTipsByTipName(HttpServletRequest request,@PathVariable("tipName") String tipName) {
        //String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
    
            // String useremail = request.getAttribute("email").toString();
            // staff staff = staffRepository.findStaffByEmail(email);
            //Integer userId = Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));
            
            String activity;
            boolean expected = false;
            for(String tipname:Constants.TIP_NAMES){
               if(tipname.equals(tipName)){
                   expected = true;
               }
          }
          if(!expected)
          throw new IllegalStateException("the tip name should be in the following set of attributes: "+Arrays.toString(Constants.TIP_NAMES));
          
           // activity = "veiwed tips  of tip name : " + tipName;
           // logsService.savelog(useremail, activity);
            List<Tips> tips=tipsRepository.getTipsByName(tipName);
            return tips;
        
    }

    @Operation(summary = "This is to delete  Tip from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  tip from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete/{tipId}")
    public Map<String, Boolean> deleteBaby(HttpServletRequest request,@PathVariable("tipId") Long tipId) throws Exception {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        boolean isStaff= false;
        boolean isHealthAdvisor= false;
        staff staff = staffRepository.findStaffByEmail(useremail);
       
        if(staff != null)
        {
            isStaff = true;
            isHealthAdvisor= false;
        }
             
        HealthAdvisor healthAdvisor = healthAdvisorRepository.findByEmailAddress(useremail);
        if (healthAdvisor != null){
            isStaff = false;
            isHealthAdvisor= true;
        }

        if (role.equals("ADMIN")|| role.equals("HOSPITAL_ADMIN")|| isStaff|| isHealthAdvisor) {
            Tips tip = tipsRepository.findByTipId(tipId);
        
            if (tip == null) {
                throw new ResourceNotFoundException("tip  not found :: " +tipId );
            }
            tipsRepository.delete(tip);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted health tip: " + tipId;
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only admin and  can delete health tip data :: ");
        }
    }

    @Operation(summary = "This is to update  health tip  to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update  health tip  to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{tipId}")
    public ResponseEntity<Tips> updateBaby(HttpServletRequest request,@PathVariable("tipId") String tipId,
            @Valid @RequestBody Tips tips) {
        String role = request.getAttribute("role").toString();
        String useremail = request.getAttribute("email").toString();
        boolean isStaff= false;
        boolean isHealthAdvisor= false;
        staff staff = staffRepository.findStaffByEmail(useremail);
       
        if(staff != null)
        {
            isStaff = true;
            isHealthAdvisor= false;
        }
             
        HealthAdvisor healthAdvisor = healthAdvisorRepository.findByEmailAddress(useremail);
        if (healthAdvisor != null){
            isStaff = false;
            isHealthAdvisor= true;
        }

        if (role.equals("ADMIN")|| role.equals("HOSPITAL_ADMIN")|| isStaff|| isHealthAdvisor)  {
            Tips tip = tipsRepository.findByTipId(Long.parseLong(tipId));
        
            if (tip == null) {
                throw new ResourceNotFoundException("tip  not found :: " +tipId );
            }
            if(tips.getTip_name()!= null){
                boolean expected = false;
              for(String tipName:Constants.TIP_NAMES){
                 if(tipName.equals(tips.getTip_name())){
                     expected = true;
                 }
            }
            if(!expected)
            throw new IllegalStateException("the tip name should be in the following set of attributes: "+Arrays.toString(Constants.TIP_NAMES));
            }
            tip.setDescription(tips.getDescription()== null? tip.getDescription():tips.getDescription());
            tip.setTitle(tips.getTitle()== null? tip.getTitle():tips.getTitle());
            tip.setTip_name(tips.getTip_name()== null? tip.getTip_name():tips.getTip_name());

            final Tips updatedTip = tipsRepository.save(tip);
            String activity = "updated tip: " + tipId;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedTip);
        } else {
            throw new AuthException("Only admin and  can update tip data :: ");
        }
        }
        }

