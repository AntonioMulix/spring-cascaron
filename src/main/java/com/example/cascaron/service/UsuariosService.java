/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.service;

import com.example.cascaron.DTO.UsuariosDTO;
import com.example.cascaron.entity.Usuarios;
import java.util.List;

/**
 *
 * @author marco-romero
 */
public interface UsuariosService {
    
        // ****************** CRUD de Usuarios ***********************

    //Listar todos los usuarios
    public List<Usuarios> findAll();

    //Guardar nuevo usuario
//    public Usuarios save(UsuarioGuardarDTO usuario);
    public Usuarios save(UsuariosDTO usuario);

    //Encontrar un usuario por id
    public Usuarios findOne(Integer id);

    //Actualizar Usuario
    public Usuarios updateUsuario(Integer id, UsuariosDTO usuarioDTO);

    
}
