/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.service;

import com.example.cascaron.entity.UsuarioRol;
import java.util.Optional;

/**
 *
 * @author marco-romero
 */
public interface UsuarioRolService {

    public UsuarioRol save(UsuarioRol usuarioRol);

    public UsuarioRol findOne(Long usuarioId);

    public void deleteById(Long idRol);

    public Optional<UsuarioRol> findByUsuarioId(Long usuarioId);

    public UsuarioRol findByUsuario_Id(Long usuarioId);

    public void deleteRol(Long usuarioId, Long rolId);
}
