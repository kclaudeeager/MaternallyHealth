package com.DU.api.controller;

import com.DU.api.model.Message;
import com.DU.api.model.User;
import com.DU.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    User user;
    @GetMapping("/")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    @GetMapping("/mine")
    public List<Message> getSentByLoggedInUser(HttpServletRequest request) {
        long senderId =  Long.parseLong(request.getAttribute("userId").toString());
    
        return messageRepository.findBySenderIdAndModifiedTime((int) senderId);
    }
    @GetMapping("/{id}")
    public Optional<Message> getMessageById(@PathVariable Long id) {
        return messageRepository.findById(id);
    }

    @GetMapping("/{senderId}")
    public ResponseEntity<List<Message>> getMessagesBySenderId(@PathVariable int senderId, HttpServletRequest request) {
        Object senderIdAttribute = request.getAttribute("userId");
        if (senderIdAttribute == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int requestedSenderId = (int) senderIdAttribute;
        if (requestedSenderId != senderId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        List<Message> messages = messageRepository.findBySenderIdAndModifiedTime(senderId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Message createMessage(@RequestBody Message message, HttpServletRequest request) {
 
      long senderId =  Long.parseLong(request.getAttribute("userId").toString());
       
     System.out.println("sender id: "+senderId);
        message.setSender_id((int) senderId);
        return messageRepository.save(message);
   
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message message) {
        message.setId(id);
        return messageRepository.saveAndFlush(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }
}
