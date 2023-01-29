package com.DU.api.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DU.api.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.sender_id = :sender_id")
    List<Message> findBySenderIdAndModifiedTime(@Param("sender_id") int senderId);


    List<Message> findByTextContaining(String text);
    
    // Get all messages
    @Override
    List<Message> findAll();
    
    // Get message by id
    @Override
    Optional<Message> findById(Long id);
     
    // Save a new message
    @Override
    Message save(Message message);
     
    // Update an existing message
    @Override
    Message saveAndFlush(Message message);
     
    // Delete a message
    @Override
    void deleteById(Long id);
     
}
