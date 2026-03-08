/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.serviceImpl;

import com.example.cascaron.DTO.UsuariosDTO;
import com.example.cascaron.entity.Usuarios;
import com.example.cascaron.repository.UsuariosRepository;
import com.example.cascaron.service.UsuariosService;
import com.example.cascaron.util.Constantes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marco-romero
 */
@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.listAllUsuarios();
    }

    //Guardar nuevo usuario
    @Transactional
    @Override
    public Usuarios save(UsuariosDTO usuarioDTO) {
        Usuarios user = new Usuarios();
        user.setNombre(usuarioDTO.getNombre());
        user.setEmail(usuarioDTO.getEmail());
        user.setEstatus(Constantes.USUARIO_ACTIVO);
        return usuariosRepository.save(user);
    }

    //Encontrar un registro
    @Transactional(readOnly = true)
    @Override
    public Usuarios findOne(Integer id) {
        return usuariosRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Usuarios updateUsuario(Integer id, UsuariosDTO usuarioDTO) {
        Usuarios user = usuariosRepository.findById(id).get();
        user.setNombre(usuarioDTO.getNombre());
        user.setEmail(usuarioDTO.getEmail());
        user.setEstatus(Constantes.USUARIO_ACTIVO);
        return usuariosRepository.save(user);
    }

}
