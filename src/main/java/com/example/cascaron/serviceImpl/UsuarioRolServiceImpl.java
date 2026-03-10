/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.serviceImpl;

import com.example.cascaron.entity.UsuarioRol;
import com.example.cascaron.repository.UsuarioRolRepository;
import com.example.cascaron.service.UsuarioRolService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marco-romero
 */
@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Transactional
    @Override
    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioRol findOne(Long usuarioId) {
        return usuarioRolRepository.findById(usuarioId).get();
    }

    @Transactional
    @Override
    public void deleteById(Long idRol) {
        usuarioRolRepository.deleteById(idRol);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UsuarioRol> findByUsuarioId(Long usuarioId) {
        return usuarioRolRepository.findById(usuarioId);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioRol findByUsuario_Id(Long usuarioId) {
        return usuarioRolRepository.findByUsuarioId(usuarioId);
    }

    @Transactional
    @Override
    public void deleteRol(Long usuarioId, Long rolId) {
        usuarioRolRepository.deleteRol(usuarioId, rolId);
    }

}
