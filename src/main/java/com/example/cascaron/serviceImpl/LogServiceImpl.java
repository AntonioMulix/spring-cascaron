/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.serviceImpl;

import com.example.cascaron.entity.AdminLog;
import com.example.cascaron.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cascaron.repository.LogRepository;

/**
 *
 * @author marco-romero
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public AdminLog save(AdminLog adminLog) {
        return logRepository.save(adminLog);
    }

}
