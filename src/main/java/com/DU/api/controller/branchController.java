package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.DU.api.exception.AuthException;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.User;
import com.DU.api.model.branch;
import com.DU.api.repository.BranchRepository;
import com.DU.api.service.LogsService;

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
@RequestMapping("/api/v1")
public class branchController {

        @Autowired
        private BranchRepository branchRepository;
        Logger log = LoggerFactory.getLogger(branchController.class);
        @Autowired
        LogsService logsService;

        @Operation(summary = "This is to add an a branch  from the  Db", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Adding new branch to database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")
        @Hidden
        @PostMapping("/branches")
        public branch createbBranch(HttpServletRequest request, @Valid @RequestBody branch branch) {
                String role = request.getAttribute("role").toString();
                // System.out.println("role: -------- " + role);
                String useremail = request.getAttribute("email").toString();
                int i = Integer.parseInt(role);
                if (i == 4) {

                        String activity = "Added  anew branch";

                        // System.out.println("user email: " + useremail);
                        logsService.savelog(useremail, activity);
                        log.debug("{} created new branch succefully", useremail);
                        return branchRepository.save(branch);
                } else {
                        log.debug("{} created branch but was not authorised", useremail);
                        throw new AuthException("Only admin can a create new branch  :: ");
                }
        }

        @Operation(summary = "This is to view all branche's data  from the  Db", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "fetch all  branches from database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")
        @Hidden
        @GetMapping("/branches/details")
        public List<branch> getAllbranches(HttpServletRequest request) {

                String activity = "viewed all data of branches";
                String useremail = request.getAttribute("email").toString();
                logsService.savelog(useremail, activity);
                log.debug("{} requested all branches's data", useremail);
                // System.out.println("user email is :" + useremail);

                return branchRepository.findAll();
        }

        @Operation(summary = "This is to get branch by branchname  from the  Db", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "fetch  branch by branchname from database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")
        @GetMapping("/branches/{branchname}")
        public ResponseEntity<branch> getBranchyByName(HttpServletRequest request,
                        @PathVariable(value = "branchname") String branchname) {
                branch branch = branchRepository.findBranchByName(branchname);
                String useremail = request.getAttribute("email").toString();
                if (branch == null) {
                        log.debug("{} requested branch's data by branchname: {} branch not found", useremail,
                                        branchname);
                        throw new ResourceNotFoundException("branch  not found :: " + branchname);
                }
                String activity = "viewed :" + branchname + "'s data";

                logsService.savelog(useremail, activity);
                log.debug("{} requested branche's data by branchname: {}  branch found succefully", useremail,
                                branchname);
                return ResponseEntity.ok().body(branch);
        }

        @Operation(summary = "This is to delete an agent  from the  Db", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "delete  branch by branchname from database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")
        @Hidden
        @DeleteMapping("/branches/{branchname}")
        public Map<String, Boolean> deletbranch(HttpServletRequest request,
                        @PathVariable(value = "branchname") String branchname) {
                String role = request.getAttribute("role").toString();
                // System.out.println("role: -------- " + role);
                int i = Integer.parseInt(role);
                String useremail = request.getAttribute("email").toString();
                if (i == 4) {
                        branch branch = branchRepository.findBranchByName(branchname);
                        if (branch == null) {
                                log.debug("{} tried to delete branch's data by branchname: {} branch not found",
                                                useremail, branchname);
                                throw new ResourceNotFoundException("branch not found :: " + branchname);
                        }
                        String activity = "deleted " + branchname + "'s data";

                        logsService.savelog(useremail, activity);

                        branchRepository.delete(branch);
                        Map<String, Boolean> response = new HashMap<>();
                        response.put("deleted", Boolean.TRUE);
                        return response;
                } else {
                        log.debug("{} tried to delete branch's data by branchname: {} but was not authorised",
                                        useremail,
                                        branchname);
                        throw new AuthException("Only admin can delete branch data  :: ");
                }
        }

        @Operation(summary = "This is to update branch  in the  Db", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "update  branch by branchname from database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")
        @Hidden
        @PutMapping("/branches/{branchname}")
        public ResponseEntity<branch> updatebranch(HttpServletRequest request,
                        @PathVariable(value = "branchname") String branchname,
                        @Valid @RequestBody branch branchDetails) {
                String role = request.getAttribute("role").toString();
                // System.out.println("role: -------- " + role);
                int i = Integer.parseInt(role);
                String useremail = request.getAttribute("email").toString();
                if (i == 4) {
                        branch branch = branchRepository.findBranchByName(branchname);
                        if (branch == null) {
                                log.debug("{} tried to alter branch's data by branchname: {} branch was not foun",
                                                useremail,
                                                branchname);
                                throw new ResourceNotFoundException("branch not found :: " + branchname);
                        }

                        branch.setbranchManager(branchDetails.getbranchname());
                        branch.setbranchManager(branchDetails.getbranchManager());
                        branch.setaddress(branchDetails.getaddress());
                        branch.setstaffNumber(branchDetails.getstaffNumber());
                        // branch.setId(branchDetails.getId());
                        branch.setopeningHour(branchDetails.getopeningHour());
                        branch.setclosingHour(branchDetails.getclosingHour());
                        branch.setphoneNumber(branchDetails.getphoneNumbe());
                        final branch updatedsbBranch = branchRepository.save(branch);
                        String activity = "Updated " + branchname + "'s data";

                        logsService.savelog(useremail, activity);
                        log.debug("{} updated branch's data by branchname: {} :succefully", useremail,
                                        branchname);
                        return ResponseEntity.ok(updatedsbBranch);
                } else {
                        log.debug("{} tried to alter branch's data by branchname: {} but was not authorised", useremail,
                                        branchname);
                        throw new AuthException("Only admin can update  branch data  :: ");
                }
        }

        @Operation(summary = "This is to view a list of all branches ", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "fetch a list of   branches from database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")

        @GetMapping("/branches/all")
        public List<Object> getallbranchlist(HttpServletRequest request) {

                String activity = "viewed all data of branches";
                String useremail = request.getAttribute("email").toString();
                logsService.savelog(useremail, activity);
                log.debug("{} requested all branches's data", useremail);

                // System.out.print("@@@@@@@@@@@@@@ + t.iterator());
                return branchRepository.findAllBranch();
        }

        @Operation(summary = "This is to view a list of all branches in a district ", security = @SecurityRequirement(name = "bearerAuth"))
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "fetch a list of branches in a given district from database", content = {
                                        @Content(mediaType = "application/json") }),
                        @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
                        @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
        @SecurityRequirement(name = "bearerAuth")

        @GetMapping("/branches/district/{district}")
        public List<Object> getbranchbydistrict(HttpServletRequest request,
                        @PathVariable(value = "district") String district) {

                String activity = "viewed all data of branches";
                String useremail = request.getAttribute("email").toString();
                logsService.savelog(useremail, activity);
                log.debug("{} requested all branches's data", useremail);

                // System.out.print("@@@@@@@@@@@@@@ + t.iterator());
                return branchRepository.findbranchBydistrict(district);
        }

}