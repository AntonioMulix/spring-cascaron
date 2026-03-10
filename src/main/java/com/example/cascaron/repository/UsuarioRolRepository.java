/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.repository;

import com.example.cascaron.entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marco-romero
 */
@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    @Query(value = "SELECT * FROM usuarios_roles u WHERE u.usuario_id = :usuarioId", nativeQuery = true)
    UsuarioRol findByUsuarioId(@Param("usuarioId") Long usuarioId);

    //************************** ELIMINAR ROL DE USUARIO ************************
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios_roles WHERE usuario_id = :usuarioId AND rol_id = :rolId", nativeQuery = true)
    void deleteRol(@Param("usuarioId") Long usuarioId, @Param("rolId") Long rolId);

}
