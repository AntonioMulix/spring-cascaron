/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.service;

import com.example.cascaron.dto.AuthResponseDTO;
import com.example.cascaron.dto.LoginRequestDTO;

/**
 *
 * @author marco-romero
 */
public interface AuthService {

    public AuthResponseDTO login(LoginRequestDTO request);
}
