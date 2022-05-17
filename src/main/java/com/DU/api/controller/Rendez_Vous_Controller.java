package com.DU.api.controller;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
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
@RequestMapping("/api/v1/Rendez-VOus")
public class Rendez_Vous_Controller {
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
    private @Valid Rendez_vous rendez_vous;
    @Autowired
    Rendez_Vous_Repository rendezVousRepository;

    @Operation(summary = "This is to add new rendez-vou to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add new consultation to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PostMapping("/add")
    public Rendez_vous createRendez_vous(HttpServletRequest request,
            @Valid @RequestBody Rendez_vous rendez_vous) throws NotFoundException {
        this.request = request;
        this.rendez_vous = rendez_vous;
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        System.out.println("rendez_vous " + rendez_vous.toString());

        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN") || role.equals("DOCTOR") || role.equals("NURSE")|| role.equals("MOTHER")) {
            String activity = "make a rendez_vous";
            logsService.savelog(useremail, activity);
            // System.out.println("Healthadvisor hospital id is
            // long:"+healthAdvisor.getHospital_id());
            Hospital hospital = hospitalRepository.findByHospitalId((rendez_vous.getHospitalId()));
            // Integer userId=Integer.parseInt(request.getParameter("userId").toString());
        

            if (hospital == null)
                throw new NotFoundException("Hospital not found with id " + rendez_vous.getHospitalId());
            log.info("{} Create new rendez_vous ", useremail);
           // staff staff = staffRepository.findStaffByEmail(useremail);
            Mother mother = motherRepository.findByMotherId(rendez_vous.getMother_id());
            staff staff = staffRepository.findByStaffId(rendez_vous.getStuff_id());
            if(mother == null)
              throw new ResourceNotFoundException("mother not found ::");
              if(staff == null)
              throw new ResourceNotFoundException("staff not found ::");
              rendez_vous.setFeedback("NO");
            return rendezVousRepository.save(rendez_vous);
        } else {
            log.warn("{} Tried Create new rendez_vous but was not authorised ", useremail);
            throw new AuthException(" Only authorized can register new doctor advise :: ");
        }

    }

    @Operation(summary = "This is to fetch all rendez_vous from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch all rendez_vous from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/all")
    public List<Rendez_vous> getAllRendez_vous(HttpServletRequest request) {
        String role = request.getAttribute("role").toString();
        String email = request.getAttribute("email").toString();
        System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        if (role.equals("DOCTOR") || role.equals("NURSE") || role.equals("ADMIN") ||
                role.equals("RECEPTIONIST") || role.equals("HOSPITAL_ADMIN")) {

            String activity = "veiwed all  doctor rendez_vous";

            logsService.savelog(email, activity);
            return rendezVousRepository.findAll();
        } else {
            throw new AuthException("Only users with roles can view all rendez_vous details data :: ");

        }
    }

    @Operation(summary = "This is to delte  rendez_vous from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete  consultation from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @DeleteMapping("/delete/{rendez_vous_id}")
    public Map<String, Boolean> deleteRendez_vous(HttpServletRequest request,
            @PathVariable(value = "rendez_vous_id") String rendez_vous_id) {
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();

        staff staff = staffRepository.findStaffByEmail(useremail);
        Rendez_vous rendez_vous=rendezVousRepository.findRendezvousById(Long.parseLong(rendez_vous_id));
        //consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
       if(rendez_vous==null){
           throw new ResourceNotFoundException(String.format("No rendez_vous found for id: %s", rendez_vous_id));
       }
        if (staff == null)
            throw new ResourceNotFoundException(
                    "no staff found with such id :: " + rendez_vous_id + " ");
        if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
                || rendez_vous.getStuff_id().equals(staff.getId())) {

            rendezVousRepository.delete(rendez_vous);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            String activity = "deleted rendez_vous: " + rendez_vous_id;
            logsService.savelog(useremail, activity);
            return response;
        } else {
            throw new AuthException("Only authorized users and  can rendez_vous data :: ");
        }
    }

    @Operation(summary = "This is to update rendez_vouz to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update rendez_vouz to the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @PutMapping("/update/{rendez_vous_id}")
    public ResponseEntity<Rendez_vous> updateRendez_vous(HttpServletRequest request,
            @PathVariable(value = "rendez_vous_id") String rendez_vous_id,
            @Valid @RequestBody Rendez_vous rendez_vousDetails) throws ServletException{
        String role = request.getAttribute("role").toString();
        // System.out.println("role: -------- " + role);
        String useremail = request.getAttribute("email").toString();
        staff staff = staffRepository.findStaffByEmail(useremail);
        Mother mother = motherRepository.findbyMotherEmailAddress(useremail);

        boolean expected = true;
        if(mother == null && staff == null)
          expected = false;
        Rendez_vous rendez_vous=rendezVousRepository.findRendezvousById(Long.parseLong(rendez_vous_id));
        //consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
       if(rendez_vous==null){
           throw new ResourceNotFoundException(String.format("No rendez_vous found for id: %s", rendez_vous_id));
       }
       if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
       || expected ) {
      
        if(rendez_vousDetails.getFeedback()!= null){
            boolean expectedStatus= false;
            for(String feedback:Constants.RENDEZ_VOUS_FEEDBACK){
                if(feedback.equals(rendez_vousDetails.getFeedback()))
                    expectedStatus= true;
            }
        }
       rendez_vous.setFeedback(rendez_vousDetails.getFeedback()== null ? rendez_vous.getFeedback(): rendez_vousDetails.getFeedback());
       rendez_vous.setUpdatedAt(new Date());
       rendez_vous.setDescription(rendez_vousDetails.getDescription() == null ? rendez_vous.getDescription():rendez_vousDetails.getDescription());
       rendez_vous.setAtWhen(rendez_vousDetails.getAtWhen()== null ? rendez_vous.getAtWhen(): rendez_vousDetails.getAtWhen());
            // consultation.setConsultationType(
            //         consultationDetails.getConsultationType() == null ? consultation.getConsultationType()
            //                 : consultationDetails.getConsultationType());
            // consultation.setDescription(consultationDetails.getDescription() == null ? consultation.getDescription()
            //         : consultationDetails.getDescription());

            final Rendez_vous updatedRendez_vous = rendezVousRepository.save(rendez_vous);
           String activity = "updated rendez_vous: " + rendez_vous_id;
            logsService.savelog(useremail, activity);
            return ResponseEntity.ok(updatedRendez_vous);
        } else {
            throw new AuthException("Only authorized   can update rendez_vous data :: ");
        }
    }

    @Operation(summary = "This is to fetch rendez_vous by phone number from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "fetch rendez_vous by phone from the  Database", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

    @GetMapping("/{rendez_vous_id}")
    public Rendez_vous getRendez_vousById(HttpServletRequest request,
            @PathVariable("rendez_vous_id") String rendez_vous_id) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        staff staff = staffRepository.findStaffByEmail(useremail);
        Mother mother = motherRepository.findbyMotherEmailAddress(useremail);

        boolean expected = true;
        if(mother == null && staff == null)
          expected = false;
        Rendez_vous rendez_vous=rendezVousRepository.findRendezvousById(Long.parseLong(rendez_vous_id));
        //consultation consultation = consultationRepository.findByConsultionId(Long.parseLong(consultationId));
       if(rendez_vous==null){
           throw new ResourceNotFoundException(String.format("No rendez_vous found for id: %s", rendez_vous_id));
       }
       if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
       || expected ) {
    
          String  activity = "veiwed  rendez_vous with name: " + rendez_vous_id;

            logsService.savelog(useremail, activity);
           // List<consultation> consultations = new ArrayList();
            // System.out.println("mother id "+mother.getId());
            // consultations.addAll(consultationRepository.findAllByMotherId(mother.getId()));
            // System.out.println("Adivises: " + doctorAdvises);
            return rendez_vous;
        } else {
            throw new AuthException("Only nurse, doctor or admin or deducated mother rendez_vous can view rendez_vous data :: ");
        }
    }
    @GetMapping("mother/{motherID}")
    public List<Rendez_vous> getRendez_vousbyMotherId(HttpServletRequest request,
            @PathVariable("motherID") String motherID) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        staff staff = staffRepository.findStaffByEmail(useremail);
        Mother mother = motherRepository.findbyMotherEmailAddress(useremail);

        boolean expected = true;
        if(mother == null && staff == null)
          expected = false;
       Mother requiredMother= motherRepository.findByMotherId(Long.parseLong(motherID));
       if(requiredMother==null)
       throw new ResourceNotFoundException("MOther  not found  with id:: "+motherID);
       if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
       || expected ) {
    
          String  activity = "veiwed  rendez_vous with mother id: " + motherID;

            logsService.savelog(useremail, activity);
           List<Rendez_vous> rendez_vousList = new ArrayList();
            // System.out.println("mother id "+mother.getId());
            rendez_vousList.addAll(rendezVousRepository.findAllByMotherId(requiredMother.getId()));
            // System.out.println("Adivises: " + doctorAdvises);
            return rendez_vousList;
        } else {
            throw new AuthException("Only nurse, doctor or admin or deducated mother rendez_vous can view rendez_vous data :: ");
        }
    }
    @GetMapping("hospital/{hospitalId}")
    public List<Rendez_vous> getRendez_vousbyHospitalId(HttpServletRequest request,
            @PathVariable("hospitalId") String hospitalId) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        staff staff = staffRepository.findStaffByEmail(useremail);
        Mother mother = motherRepository.findbyMotherEmailAddress(useremail);
         boolean viewAll=false;
        boolean expected = true;
        if(mother == null && staff == null)
          expected = false;
       Hospital hospital= hospitalRepository.findByHospitalId(Long.parseLong(hospitalId));
       if(hospital==null)
       throw new ResourceNotFoundException("hospital  not found  with id:: "+hospitalId);
       if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
       || expected ) {
    
          String  activity = "veiwed  rendez_vous with hospital id: " + hospitalId;

            logsService.savelog(useremail, activity);
           List<Rendez_vous> rendez_vousList = new ArrayList();
            // System.out.println("mother id "+mother.getId());
            rendez_vousList.addAll(rendezVousRepository.findAllByHospitallId(hospital.getId()));
            // System.out.println("Adivises: " + doctorAdvises);
            return rendez_vousList;
        } else {
            throw new AuthException("Only nurse, doctor or admin or deducated mother rendez_vous can view rendez_vous data :: ");
        }
    }
    @GetMapping("feedback/{YES_NO}")
    public List<Rendez_vous> getRendez_vousbyFeedback(HttpServletRequest request,
            @PathVariable("YES_NO") String YES_NO) {
        String role = request.getAttribute("role").toString();
        System.out.println("role found: -------- " + role);
        // int i = Integer.parseInt(role);
        String useremail = request.getAttribute("email").toString();
        staff staff = staffRepository.findStaffByEmail(useremail);
        Mother mother = motherRepository.findbyMotherEmailAddress(useremail);
         boolean viewAll=false;
        boolean expected = true;
        if(mother == null && staff == null)
          expected = false;
       //Hospital hospital= hospitalRepository.findByHospitalId(Long.parseLong(hospitalId));
    //    if(hospital==null)
    //    throw new ResourceNotFoundException("hospital  not found  with id:: "+hospitalId);
       if (role.equals("ADMIN") || role.equals("HOSPITAL_ADMIN")
       || expected ) {
    
          String  activity = "veiwed  rendez_vous with fedback : " + YES_NO;

            logsService.savelog(useremail, activity);
           List<Rendez_vous> rendez_vousList = new ArrayList();
            // System.out.println("mother id "+mother.getId());
            rendez_vousList.addAll(rendezVousRepository.findAllByFeedback(YES_NO));
            // System.out.println("Adivises: " + doctorAdvises);
            return rendez_vousList;
        } else {
            throw new AuthException("Only nurse, doctor or admin or deducated mother rendez_vous can view rendez_vous data :: ");
        }
    }
}