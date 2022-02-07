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
// import com.DU.api.exception.BadRequest;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.agents;
import com.DU.api.repository.AgentsRepository;
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

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1")
public class AgentsController {

    @Autowired
    private AgentsRepository agentsRepository;
    @Autowired
    LogsService logsService;
    Logger log = LoggerFactory.getLogger(AgentsController.class);

    @Operation(summary = "This is to add new agent  in Db", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Add a new agent in the  Db", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),

            @ApiResponse(responseCode = "403", description = "Forbidden Authorization token must be provided", content = @Content)

    })
    @SecurityRequirement(name = "bearerAuth")
    @Hidden
    @PostMapping("/agents")
    public agents createclient(HttpServletRequest request, @Valid @RequestBody agents agent) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (i == 3 || i == 4) {
            String activity = "created new agent";
            // String useremail = request.getAttribute("email").toString();

            logsService.savelog(useremail, activity);
            log.info("{} created new agent :{}", useremail, agent.getFirstName());
            return agentsRepository.save(agent);
        } else {
            log.debug("{} created agent but was not authorised", useremail);
            throw new AuthException("Only admin and staff can create a new agent :: ");

        }
    }

    @Operation(summary = "This is to fetch all agents from   Db", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all agents from  the  Db", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),

            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/agents")
    public List<agents> getAllAgents(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        String useremail = request.getAttribute("email").toString();
        int i = Integer.parseInt(role);
        if (i == 3 || i == 4) {
            String activity = "viewed all data of agents";
            // String useremail = request.getAttribute("email").toString();
            logsService.savelog(useremail, activity);
            // System.out.println("user email is :" + useremail);
            log.debug("{} requested all agent's data", useremail);
            return agentsRepository.findAll();
        } else {
            log.debug("{} requested all agent's data but was not authorised", useremail);
            throw new AuthException("user not allowed to view this endpoint :: ");
        }
    }

    @Operation(summary = "This is to fetch  agent by Id number  from the  Db", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "This is to fetch agent by number from the  Db", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content) })
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/agents/{idnumber}")
    public ResponseEntity<agents> getAgentById(HttpServletRequest request,
            @PathVariable(value = "idnumber") String idnumber) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        String email = request.getAttribute("email").toString();
        int i = Integer.parseInt(role);
        if (i == 3 || i == 4) {
            agents agent = agentsRepository.findAgentByIdNumber(idnumber);
            if (agent == null) {
                log.debug("{} requested agent's data by idnumber: {} agent not found", email, idnumber);
                throw new ResourceNotFoundException("agent  not found :: " + idnumber);
            }
            String activity = "viewed " + idnumber + "'s data";
            log.debug("{} viewed agents data by id {} succefully", email, idnumber);
            logsService.savelog(email, activity);
            return ResponseEntity.ok().body(agent);
        } else {
            log.debug("{} viewed agents data by id {} but was not authorised", email, idnumber);
            throw new AuthException("user not allowed to view this endpoint :: ");

        }
    }

    @Operation(summary = "This is to delete an agent  from the  Db", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete an agent  from the  Db", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content) })
    @SecurityRequirement(name = "bearerAuth")
    @Hidden
    @DeleteMapping("/agents/{idnumber}")
    public Map<String, Boolean> deletAgent(HttpServletRequest request,
            @PathVariable(value = "idnumber") String idnumber) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        int i = Integer.parseInt(role);
        String email = request.getAttribute("email").toString();
        if (i == 4) {

            agents agent = agentsRepository.findAgentByIdNumber(idnumber);
            if (agent == null) {
                log.debug("{} delete agent's data by id {} but agent was not found", email, idnumber);
                throw new ResourceNotFoundException("agent not found :: " + idnumber);
            }
            agentsRepository.delete(agent);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted " + idnumber + "'s data";
            log.debug("{} deleted agent's data by id {} ", email, idnumber);
            logsService.savelog(email, activity);
            return response;
        } else {
            log.debug("{} delete agent's data by id {} but was not authorised", email, idnumber);
            throw new AuthException("user not allowed to view this endpoint :: ");

        }

    }

    @Operation(summary = "This is to update an agent  in  the  Db", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "update an agent  from the  Db", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content) })
    @SecurityRequirement(name = "bearerAuth")
    @Hidden
    @PutMapping("/agents/{idnumber}")
    public ResponseEntity<agents> updateAgent(HttpServletRequest request,
            @PathVariable(value = "idnumber") String idnumber,
            @Valid @RequestBody agents agentDetails) {

        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        int i = Integer.parseInt(role);
        String email = request.getAttribute("email").toString();
        if (i == 3 || i == 4) {
            agents agent = agentsRepository.findAgentByIdNumber(idnumber);
            if (agent == null) {
                log.warn("{} updated agent's data by id {} but agent was not found", email, idnumber);
                throw new ResourceNotFoundException("agent not found :: " + idnumber);
            }

            agent.setPhoneNumber(agentDetails.getPhoneNumber());
            agent.setFirstName(agentDetails.getFirstName());
            agent.setLastName(agentDetails.getLastName());
            agent.setcapital(agentDetails.getcapital());
            agent.setidnumber(agentDetails.getidnumber());
            agent.setresidance(agentDetails.getresidance());
            agent.setidtype(agentDetails.getidtype());
            agent.setservices(agentDetails.getservices());
            final agents updatedsAgent = agentsRepository.save(agent);
            String activity = "updated " + idnumber + "'s data";
            // String email = request.getAttribute("email").toString();
            logsService.savelog(email, activity);
            log.debug("{} updated agent's data by id {} succefully", email, idnumber);
            return ResponseEntity.ok(updatedsAgent);
        } else {
            log.debug("{} updated agent's data by id {} but agent was not authorised", email, idnumber);
            throw new AuthException("user not allowed to view this endpoint :: ");

        }
    }

    @Operation(summary = "This is to fetch  agent by Id number  from the  Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "This is to fetch agent by number from the  Db", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content) })
    // @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/agents/{location}")
    public List<agents> getAgentByLocation(
            @PathVariable(value = "location") String location) {
        // String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        String email = "test@gmail.com";
        // request.getAttribute("email").toString();

        String activity = "viewed " + " " + "'s data";
        log.debug("{} viewed agents  by location {} succefully", email, location);
        logsService.savelog(email, activity);
        return agentsRepository.findAgentBylocation(location);

    }

}
