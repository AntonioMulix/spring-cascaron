/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.controller;

import com.example.cascaron.dto.AuthResponseDTO;
import com.example.cascaron.dto.LoginRequestDTO;
import com.example.cascaron.exception.OutputEntity;
import com.example.cascaron.service.AuthService;
import com.example.cascaron.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<OutputEntity> login(
            @RequestBody LoginRequestDTO request) {
        OutputEntity<AuthResponseDTO> out = new OutputEntity<>();
        try {
            AuthResponseDTO result = authService.login(request);
            out.success(Response.OK.getCode(), Response.OK.getKey(), result);
        } catch (Exception e) {
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

}
