/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.repository;

import com.example.cascaron.entity.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    //Listar todos los usuarios
    @Query(value = "SELECT u FROM Usuarios u")
    public List<Usuarios> listAllUsuarios();
}
