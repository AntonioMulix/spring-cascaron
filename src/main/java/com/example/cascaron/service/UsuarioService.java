/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.cascaron.service;

import com.example.cascaron.dto.UsuarioDTO;
import com.example.cascaron.dto.UsuarioGuardarDTO;
import com.example.cascaron.entity.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author marco-romero
 */
public interface UsuarioService {

    // ****************** CRUD de Usuarios ***********************
    //Listar todos los usuarios
    public List<Usuario> findAll();

    //Guardar nuevo usuario
//    public Usuarios save(UsuarioGuardarDTO usuario);
    public Usuario save(UsuarioGuardarDTO usuario);

    //Encontrar un usuario por id
    public Usuario findOne(Integer id);

    //Actualizar Usuario
    public Usuario updateUsuario(Integer id, UsuarioDTO usuarioDTO);

    //Buscar usuario por username
    public Optional<Usuario> getByUsername(String username);

}
