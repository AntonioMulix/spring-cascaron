/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.repository;

import com.example.cascaron.entity.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marco-romero
 */
public interface LogRepository extends JpaRepository<AdminLog, Long> {

}
