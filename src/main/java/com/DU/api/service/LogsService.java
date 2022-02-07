package com.DU.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import com.DU.api.controller.UserController;
import com.DU.api.model.Logs;
import com.DU.api.model.User;
import com.DU.api.repository.LogsRepository;

@Service
@Transactional
public class LogsService {
    @Autowired
    LogsRepository logsRepository;
    @Autowired
    UserController usercontroller;

    public void savelogs(@Lazy User user, String activity) {
        // String tok = usercontroller.token;
        // System.out.println(" my tok value is :" + tok);
        Logs logs = new Logs();
        logs.setEmail(user.getEmail());
        logs.setActivity(activity);
        logs.settime(new Date());

        logsRepository.save(logs);
    }

    public void savelog(String email, String activity) {
        // String tok = usercontroller.token;
        // System.out.println(" my tok value is :" + tok);
        Logs logs = new Logs();
        logs.setEmail(email);
        logs.setActivity(activity);
        logs.settime(new Date());

        logsRepository.save(logs);
    }

}