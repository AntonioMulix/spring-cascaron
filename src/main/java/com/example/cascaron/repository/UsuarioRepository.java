/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.repository;

import com.example.cascaron.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Listar todos los usuarios
    @Query(value = "SELECT u FROM Usuario u")
    public List<Usuario> listAllUsuarios();

    @Query(value = "SELECT u FROM Usuario u WHERE u.username =: username")
    public Optional<Usuario> findByUsername(@Param("username") String username);
}
