/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.serviceImpl;

import com.example.cascaron.dto.UsuarioDTO;
import com.example.cascaron.dto.UsuarioGuardarDTO;
import com.example.cascaron.entity.Rol;
import com.example.cascaron.entity.Usuario;
import com.example.cascaron.repository.RolRepository;
import com.example.cascaron.util.Constantes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.cascaron.repository.UsuarioRepository;
import com.example.cascaron.service.UsuarioService;
import com.example.cascaron.util.RolNombre;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author marco-romero
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.listAllUsuarios();
    }

    //Guardar nuevo usuario
    @Transactional
    @Override
    public Usuario save(UsuarioGuardarDTO usuarioDTO) {
        Usuario user = new Usuario();
        user.setNombre(usuarioDTO.getNombre());
        user.setApPaterno(usuarioDTO.getApPaterno());
        user.setApMaterno(usuarioDTO.getApMaterno());
        user.setUsername(usuarioDTO.getUsername());
        user.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        user.setEstatus(Constantes.USUARIO_ACTIVO);
        user.setEmail(usuarioDTO.getEmail());
//        Rol rolUser = rolRepository.findByName(RolNombre.ROLE_USER).get();
//        Set<Rol> roles = new HashSet<>();
//        roles.add(rolUser);
//        user.setRoles(roles);
        user.setRoles(usuarioDTO.getRoles());
        return usuarioRepository.save(user);
    }

    //Encontrar un registro
    @Transactional(readOnly = true)
    @Override
    public Usuario findOne(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    //Buscar usuario por username
    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> getByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public Usuario updateUsuario(Integer id, UsuarioDTO usuarioDTO) {
        Usuario user = usuarioRepository.findById(id).get();
        user.setNombre(usuarioDTO.getNombre());
        user.setEmail(usuarioDTO.getEmail());
        user.setEstatus(Constantes.USUARIO_ACTIVO);
        return usuarioRepository.save(user);
    }

}
