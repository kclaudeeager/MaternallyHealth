package com.DU.api.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.DU.api.exception.AuthException;
import com.DU.api.exception.ResourceNotFoundException;
import com.DU.api.model.Logs;
import com.DU.api.model.Plate;
import com.DU.api.repository.LogsRepository;
import com.DU.api.repository.plateRepository;
import com.DU.api.service.LogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class plateContorller {
    @Autowired
  private plateRepository plateRepository;
    @PostMapping("/platenumber")
  public Plate createclient(@Valid @RequestBody Plate plate) {
    return plateRepository.save(plate);
}
}
