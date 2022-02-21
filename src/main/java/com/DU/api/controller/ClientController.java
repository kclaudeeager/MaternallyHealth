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

import com.DU.api.model.client;
import com.DU.api.repository.ClientRepository;
import com.DU.api.service.LogsService;
import com.DU.api.service.AuthFilter;
import com.DU.api.service.EmailSenderService;

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
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;
  @Autowired
  LogsService logsService;
  @Autowired
  private EmailSenderService mailSender;

  // private EmailSenderService emailService;
  // private UserRepository userRepository;
  // User user;

  AuthFilter auth;

  Logger log = LoggerFactory.getLogger(ClientController.class);

  @Operation(summary = "This is to add new client to the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Add new client to the  database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")
  @Hidden
  @PostMapping("/clients")
  public client createclient(HttpServletRequest request, @Valid @RequestBody client client) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    String useremail = request.getAttribute("email").toString();
    if (i > 0) {
      String activity = "created new client";

      logsService.savelog(useremail, activity);
      log.debug("{} created new client", useremail);
      return clientRepository.save(client);
    } else {
      log.warn("{} Tried to creat new client but was not authorised", useremail);
      throw new AuthException("Only admin,staff or agent can add new client :: ");
    }
  }

  @Operation(summary = "This is to fetch all clients  from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "fetch  all clients from database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")
  @Hidden
  @GetMapping("/clients")
  public List<client> getAllclients(HttpServletRequest request) {

    String useremail = request.getAttribute("email").toString();
    String activity = "viewed all client's details";
    logsService.savelog(useremail, activity);
    log.info("{} viewed all clients data", useremail);
    // // System.out.println("USER NOW: " + useremail);

    // emailService.SendSimpleEmail("ngabojck@gmail.com", "email sender is working",
    // "Notification");

    return clientRepository.findAll();
  }

  @Operation(summary = "This is to fetch client by email  from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "fetch  client by by email from database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @SecurityRequirement(name = "bearerAuth")
  @Hidden
  @GetMapping("/clients/{email}")
  public ResponseEntity<client> getclientEmail(HttpServletRequest request,
      @PathVariable(value = "email") String email) {
    client client = clientRepository.findclientByEmail(email);
    if (client == null) {
      log.warn("Client with email: {} was not found ", email);
      throw new ResourceNotFoundException("client  not found :: " + email);
    }
    String activity = "viewed client by Email: " + email;
    String useremail = request.getAttribute("email").toString();
    logsService.savelog(useremail, activity);
    log.warn("Client's data with email: {} generated ", email);
    return ResponseEntity.ok().body(client);
  }

  @Operation(summary = "This is to delete client by email  from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "delete by email from database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })

  @SecurityRequirement(name = "bearerAuth")
  @Hidden
  @DeleteMapping("/clients/{email}")
  public Map<String, Boolean> deletclient(HttpServletRequest request, @PathVariable(value = "email") String email) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    if (i < 0) {
      client client = clientRepository.findclientByEmail(email);
      if (client == null) {
        log.warn("Client with email: {} was not found ", email);
        throw new ResourceNotFoundException("client not found :: " + email);
      }
      clientRepository.delete(client);
      Map<String, Boolean> response = new HashMap<>();
      log.warn("Client with email: {} was deleted ", email);
      response.put("deleted", Boolean.TRUE);
      return response;
    } else {
      log.warn("Tried to delete client with email: {} but was not authorised ", email);
      throw new AuthException("Only admin,staff or agent can add new client :: ");
    }
  }

  @Operation(summary = "This is to update client by email  from the  Database", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update  client by email from database", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")
  @Hidden
  @PutMapping("/clients/{email}")
  public ResponseEntity<client> updateclient(HttpServletRequest request, @PathVariable(value = "email") String email,
      @Valid @RequestBody client clientDetails) {
    String role = request.getAttribute("role").toString();
    // System.out.println("role: -------- " + role);
    int i = Integer.parseInt(role);
    if (i > 0) {

      client client = clientRepository.findclientByEmail(email);
      if (client == null) {
        log.warn("Client with email: {} was not found ", email);
        throw new ResourceNotFoundException("client not found :: " + email);
      }
      client.setPhoneNumber(clientDetails.getPhoneNumber());
      client.setEmail(clientDetails.getEmail());
      client.setFirstName(clientDetails.getFirstName());
      client.setLastName(clientDetails.getLastName());
      client.setaccountnumber(clientDetails.getaccountnumber());
      client.setidnumber(clientDetails.getidnumber());
      client.setresidance(clientDetails.getresidance());
      client.setidtype(clientDetails.getidtype());
      client.setocccupation(clientDetails.getoccupation());
      final client updatedsclient = clientRepository.save(client);
      return ResponseEntity.ok(updatedsclient);
    } else {
      log.warn("Client with email: {} was updated", email);
      throw new AuthException("Only admin,staff or agent can delete a client :: ");
    }
  }

  // transfer by idnumber

  @Operation(summary = "This is to transfer money to another client ", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Transfer money to another client ", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")

  @PutMapping("/clients/transfer/id/{idnumber}/{amount}")
  public String tranfermoney(HttpServletRequest request, @PathVariable(value = "idnumber") String idnumber,
      @PathVariable(value = "amount") Integer amount) {
    client clientReciever = clientRepository.findclientByIdnumber(idnumber);
    if (clientReciever == null) {
      return "Reciver account not found";
    } else {
      int currentAmount = clientReciever.getBalance();
      String nameR = clientReciever.getFirstName() + " " + clientReciever.getLastName();
      // System.out.println("RECIEVER BALANCE:" + nameR);
      int updatedAmount = currentAmount + amount;
      clientRepository.setbalanceForClient(updatedAmount, idnumber);
      String useremail = request.getAttribute("email").toString();
      client clientSender = clientRepository.findclientByEmail(useremail);
      String reciverEmail = clientReciever.getEmail();
      String nameS = clientSender.getFirstName() + " " + clientSender.getLastName();
      mailSender.SendSimpleEmail(reciverEmail,
          "Dear " + nameR + " You have been credited with : RWF" + amount + " from " + nameS, "Money Transfer");

      currentAmount = clientSender.getBalance();
      if (currentAmount > amount) {
        updatedAmount = currentAmount - amount;
        // System.out.println(updatedAmount);
        String idnumber1 = clientSender.getidnumber();
        clientRepository.setbalanceForClient(updatedAmount, idnumber1);
        // System.out.println(" ##################" + useremail + nameS + nameR);
        mailSender.SendSimpleEmail(useremail,
            "Dear " + nameS + "You have successfully transfered: RWF" + amount + " to " +
                nameR,
            "Money Transfer");

        return "You current balance is :" + updatedAmount;
      } else {
        return "you have a insufficient amount of funds in your account";
      }
    }

  }

  // transfer by account number

  @Operation(summary = "This is to transfer money to another client ", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Transfer money to another client ", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")
  @PutMapping("/clients/transfer/account/{accountnumber}/{amount}")
  public String tranfermoneyByAccount(HttpServletRequest request,
      @PathVariable(value = "accountnumber") String accountnumber,
      @PathVariable(value = "amount") Integer amount) {

    client clientReciever = clientRepository.findclientByAccount(accountnumber);
    if (clientReciever != null) {
      String idnReciever = clientReciever.getidnumber();

      int currentAmount = clientReciever.getBalance();
      // System.out.println("********client found*********");
      String nameR = clientReciever.getFirstName() + " " + clientReciever.getLastName();
      // System.out.println("###########RECIEVER BALANCE:" + nameR);
      int updatedAmount = currentAmount + amount;

      clientRepository.setbalanceForClient(updatedAmount, idnReciever);
      String useremail = request.getAttribute("email").toString();
      client clientSender = clientRepository.findclientByEmail(useremail);
      String reciverEmail = clientReciever.getEmail();
      String nameS = clientSender.getFirstName() + " " + clientSender.getLastName();
      mailSender.SendSimpleEmail(reciverEmail,
          "Dear " + nameR + " You have been credited with : RWF" + amount + " from " +
              nameS,
          "Money Transfer");

      currentAmount = clientSender.getBalance();
      if (currentAmount > amount) {
        updatedAmount = currentAmount - amount;
        // System.out.println(updatedAmount);
        String idnumber1 = clientSender.getidnumber();
        clientRepository.setbalanceForClient(updatedAmount, idnumber1);
        // System.out.println(" ##################" + useremail + nameS + nameR);
        mailSender.SendSimpleEmail(useremail,
            "Dear " + nameS + "You have successfully transfered: RWF" + amount + " to " +
                nameR,
            "Money Transfer");

        return "You current balance is :" + updatedAmount;
      } else {
        return "you have a insufficient amount of funds in your account";

      }
    } else {
      return "account notfound";
    }

  }

  // transfer by phonenumber
  @Operation(summary = "This is to transfer money to another client ", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Transfer money to another client ", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")
  @PutMapping("/clients/transfer/phonenumber/{phonenumber}/{amount}")
  public String tranfermoneyByPhoneNumber(HttpServletRequest request,
      @PathVariable(value = "phonenumber") String phonenumber,
      @PathVariable(value = "amount") Integer amount) {
    client clientReciever = clientRepository.findclientByPhoneNumber(phonenumber);
    if (clientReciever == null) {
      return "Reciver account not found";
    } else {
      int currentAmount = clientReciever.getBalance();
      String nameR = clientReciever.getFirstName() + " " + clientReciever.getLastName();
      // System.out.println("RECIEVER BALANCE:" + nameR);
      int updatedAmount = currentAmount + amount;
      clientRepository.setbalanceForClientByPhonenumber(updatedAmount, phonenumber);
      String useremail = request.getAttribute("email").toString();
      client clientSender = clientRepository.findclientByEmail(useremail);
      String reciverEmail = clientReciever.getEmail();
      String nameS = clientSender.getFirstName() + " " + clientSender.getLastName();
      // mailSender.SendSimpleEmail(reciverEmail,
      // "Dear " + nameR + " You have been credited with : RWF" + amount + " from " +
      // nameS, "Money Transfer");

      currentAmount = clientSender.getBalance();
      if (currentAmount > amount) {
        updatedAmount = currentAmount - amount;
        // System.out.println(updatedAmount);
        String idnumber1 = clientSender.getidnumber();
        clientRepository.setbalanceForClientByPhonenumber(updatedAmount, idnumber1);
        // System.out.println(" ##################" + useremail + nameS + nameR);
        // mailSender.SendSimpleEmail(useremail,
        // "Dear " + nameS + "You have successfully transfered: RWF" + amount + " to " +
        // nameR,
        // "Money Transfer");

        return "You current balance is :" + updatedAmount;
      } else {
        return "you have a insufficient amount of funds in your account";
      }
    }

  }

  // Get Balance

  @Operation(summary = "This is to check the balance of the logged in client", security = @SecurityRequirement(name = "bearerAuth"))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "This is to check the balance of the logged in client", content = {
          @Content(mediaType = "application/json") }),
      @ApiResponse(responseCode = "404", description = "NOt Available", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden, Authorization token must be provided", content = @Content) })
  @SecurityRequirement(name = "bearerAuth")
  @GetMapping("/clients/balance")
  public int getclientBalance(HttpServletRequest request) {

    String email = request.getAttribute("email").toString();
    client client = clientRepository.findclientByEmail(email);

    return client.getBalance();

  }

}