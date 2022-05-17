package com.DU.api.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.ArrayList;
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
@RequestMapping("/api/v1/Consultation")

public class ConsultationController {

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    LogsService logsService;
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private MotherRepository motherRepository;
    @Autowired
    private BabyRepository babyRepository;
    Logger log = LoggerFactory.getLogger(ConsultationController.class);
    User user;
    @Autowired
    private StaffRepository staffRepository;
    private @Valid staff staff;
    Hospital hospital;
    private HttpServletRequest request;
    private consultation consultation;

    @Operation(summary = "This is to add new consultation to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new consultation to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public consultation createConsultation(HttpServletRequest request,
            @Valid @RequestBody consultation consultation) throws NotFoundException {
        this.request = request;
        this.consultation = consultation;
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        System.out.println("consultation " + consultation.toString());
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN") || role.equals("DOCTOR") || role.equals("NURSE")) {
            String activity = "make a consultation";
            logsService.savelog(useremail, activity);
            // System.out.println("Healthadvisor hospital id is
            // long:"+healthAdvisor.getHospital_id());
            Hospital hospital = hospitalRepository.findByHospitalId((consultation.getHospitalId()));
            // Integer userId=Integer.parseInt(request.getParameter("userId").toString());
            boolean ismother = false;
            boolean isBaby = false;
            if (consultation.getPatientType() != null) {
                boolean success = false;
                for (String patientType : Constants.PATIENT_TYPES) {
                    if (patientType.equals(consultation.getPatientType())) {
                        success = true;
                    }
                }
                if (!success)
                    throw new IllegalStateException("Invalid patient type: " + consultation.getPatientType()
                            + " patient type must be in the following set of patient types: "
                            + Arrays.toString(Constants.PATIENT_TYPES));
            }

            if (consultation.getPatientType().equals(Constants.PATIENT_TYPES[0])) {
                Mother mother = motherRepository.findByMotherId((long) (consultation.getPatientId()));
                if (mother == null) {
                    throw new ResourceNotFoundException(
                            "mother with such id not found :: " + consultation.getPatientId());
                }
            } else {
                Baby baby = babyRepository.findBabyById((long)consultation.getPatientId());
                if (baby == null) {
                    throw new ResourceNotFoundException(
                            "baby with such id not found :: " + consultation.getPatientId());
                }
            }

            if (hospital == null)
                throw new NotFoundException("Hospital not found with id " + consultation.getHospitalId());
            log.info("{} Create new consultation ", useremail);
            staff staff = staffRepository.findStaffByEmail(useremail);

            consultation.setConsulterId(Integer.parseInt(request.getAttribute("userId").toString()));
            return consultationRepository.save(consultation);
        } else {
            log.warn("{} Tried Create new doctor advise but was not authorised ", useremail);
            throw new AuthException(" Only authorized can register new doctor advise :: ");
        }

    }

    @Operation(summary = "This is to fetch all consultations from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all consultations from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<consultation> getAllConsultations(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST") || role.equals("HOSPITAL_ADMIN")) {

            String activity = "veiwed all  doctor consultations";

            logsService.savelog(email, activity);
            return consultationRepository.findAll();
        } else {
            throw new AuthException("Only users with roles can view all consultations details data :: ");

        }
    }

    @Operation(summary = "This is to delte  doctor advise from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  doctor advise from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete/{consultationId}")
    public Map<String, Boolean> deleteConsultationById(HttpServletRequest request,
            @PathVariable(value = "consultationId") String consultationId) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();

        staff staff = staffRepository.findStaffByEmail(useremail);
        consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
        if (consultation == null)
            throw new ResourceNotFoundException(
                    "no consultation found with such id :: " + consultationId + " ");
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
                || consultation.getConsulterId().equals(staff.getId())) {

            consultationRepository.delete(consultation);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted consultation: " + consultationId;
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only authorized users and  can consultation data :: ");
        }
    }

    @Operation(summary = "This is to update consultation to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update consultation to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{consultationId}")
    public ResponseEntity<consultation> updateConsultation(HttpServletRequest request,
            @PathVariable(value = "consultationId") String consultationId,
            @Valid @RequestBody consultation consultationDetails) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        String useremail = request.getAttribute("email").toString();
        staff staff = staffRepository.findStaffByEmail(useremail);
        consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
        if (consultation == null)
            throw new ResourceNotFoundException(
                    "no consultation found with such id :: " + consultationId + " ");
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
                || consultation.getConsulterId().equals(staff.getId())) {

            consultation.setConsultationType(
                    consultationDetails.getConsultationType() == null ? consultation.getConsultationType()
                            : consultationDetails.getConsultationType());
            consultation.setDescription(consultationDetails.getDescription() == null ? consultation.getDescription()
                    : consultationDetails.getDescription());

            final consultation updatedconsultation = consultationRepository.save(consultation);
            String activity = "updated consultation: " + consultationId;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedconsultation);
        } else {
            throw new AuthException("Only admins and  can update consultation data :: ");
        }
    }

    @Operation(summary = "This is to fetch consultation by phone number from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch consultation by phone from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/{consultationId}")
    public consultation getCounsultationById(HttpServletRequest request,
            @PathVariable("consultationId") String consultationId) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
        String useremail = request.getAttribute("email").toString();
        String activity;
        if (consultation == null) {
            throw new ResourceNotFoundException("consultation with such id not found :: " + consultationId);
            // System.out.println(("staff not found :: " + email));
        }
        // System.out.println("<<<<<<<>>>>>>"+mother.getPhoneNumber());
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST")
                || role.equals("HOSPITAL_ADMIN")) {

            // staff staff = staffRepository.findStaffByEmail(email);
            // Integer userId =
            // Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));

            activity = "veiwed  consultation with name: " + consultationId;

            logsService.savelog(useremail, activity);
            List<consultation> consultations = new ArrayList();
            // System.out.println("mother id "+mother.getId());
            // consultations.addAll(consultationRepository.findAllByMotherId(mother.getId()));
            // System.out.println("Adivises: " + doctorAdvises);
            return consultation;
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother can view consultation data :: ");
        }
    }
    @GetMapping("/patient/{patientId}")
    public List<consultation> getCounsultationsById(HttpServletRequest request,
            @PathVariable("patientId") Integer patientId ) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
       // consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
        String useremail = request.getAttribute("email").toString();
        String activity;
        // if (consultation == null) {
        //     throw new ResourceNotFoundException("consultation with such id not found :: " + consultationId);
        //     // System.out.println(("staff not found :: " + email));
        // }
        // System.out.println("<<<<<<<>>>>>>"+mother.getPhoneNumber());
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST")
                || role.equals("HOSPITAL_ADMIN")|| role.equals("MOTHER")) {

            // staff staff = staffRepository.findStaffByEmail(email);
            // Integer userId =
            // Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));

            activity = "veiwed  consultation with patient id: " + patientId;

            logsService.savelog(useremail, activity);
            List<consultation> consultations = new ArrayList();
            // System.out.println("mother id "+mother.getId());
             consultations.addAll(consultationRepository.findBypatientId(patientId));
            // System.out.println("Adivises: " + doctorAdvises);
            return consultations;
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother can view consultation data :: ");
        }
    }
    @GetMapping("/patientType/{patient_type}")
    public List<consultation> getCounsultationsByPatientType(HttpServletRequest request,
            @PathVariable("patient_type") String patient_type ) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
       // consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
        String useremail = request.getAttribute("email").toString();
        String activity;
        // if (consultation == null) {
        //     throw new ResourceNotFoundException("consultation with such id not found :: " + consultationId);
        //     // System.out.println(("staff not found :: " + email));
        // }
        // System.out.println("<<<<<<<>>>>>>"+mother.getPhoneNumber());
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST")
                || role.equals("HOSPITAL_ADMIN")|| role.equals("MOTHER")) {

            // staff staff = staffRepository.findStaffByEmail(email);
            // Integer userId =
            // Integer.parseInt(request.getAttribute("user_id").toString());
            // User user = userRepository.findByUserId(Integer.parseInt(motherId));

            activity = "veiwed  consultation with patient type: " + patient_type;

            logsService.savelog(useremail, activity);
            List<consultation> consultations = new ArrayList();
            // System.out.println("mother id "+mother.getId());
             consultations.addAll(consultationRepository.findBypatientType(patient_type));
            // System.out.println("Adivises: " + doctorAdvises);
            return consultations;
        } else {
            throw new AuthException("Only nurse, doctor or admin or mother can view consultation data :: ");
        }
    }


}