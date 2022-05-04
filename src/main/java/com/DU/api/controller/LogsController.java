package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.DU.api.exception.AuthException;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.Logs;
import com.DU.api.repository.LogsRepository;
import com.DU.api.service.LogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// @Hidden
@RestController
@RequestMapping("/api/v1")
public class LogsController {
    @Autowired
    LogsService logsService;
    @Autowired
    private LogsRepository logsRepository;
    Logger log = LoggerFactory.getLogger(LogsController.class);

    @Operation(summary = "This is to fetch all logs from the  Database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch  all logs from database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/logs")
    public List<Logs> getAlllogs(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
       // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        if (role.equals("ADMIN")){

            String activity = "viewed all logs";
            logsService.savelog(useremail, activity);
            log.info("{} Logs generated", useremail);
            // System.out.println("USER NOW: " + useremail);
            return logsRepository.findAll();
        } else {
            log.warn("{} Tried to view all system logs but was not authorised", useremail);
            throw new AuthException("Only admin can  view logs  :: ");
        }
    }

    @Operation(summary = "This is to fetch  logs by user email from the  Database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch   logs by user emailfrom database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/logs/{email}")
    public List<Logs> getlogsbyEmail(HttpServletRequest request,
            @PathVariable(value = "email") String email) {
        String role = request.getAttribute("role").toString();
        String useremail = request.getAttribute("email").toString();
        // System.out.println("role: -------- " + role);
        if (role.equals("ADMIN")) {
            List<Logs> logs = logsRepository.findLogsByEmail(email);
            if (logs == null) {
                log.info("logs of user: {}", email);
                throw new ResourceNotFoundException("logs  not found :: " + email);
            }

            String activity = "viewed logs by Email: " + email;

            logsService.savelog(useremail, activity);
            return logsRepository.findLogsByEmail(email);
        } else {
            log.warn("{} Tried to view logs but was not authorised", useremail);
            throw new AuthException("Only admin can a view logs  :: ");
        }

    }
}
