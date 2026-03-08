/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.controller;

import com.example.cascaron.DTO.UsuariosDTO;
import com.example.cascaron.config.SystemControllerLog;
import com.example.cascaron.entity.Usuarios;
import com.example.cascaron.exception.OutputEntity;
import com.example.cascaron.service.UsuariosService;
import com.example.cascaron.util.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    //Busca a todos los usuarios activos y no activos
    @SystemControllerLog(operation = "listarUsuarios", type = "obtuvo lista de todos los  usuarios") //Log de quien ejecuta el metodo
    @GetMapping(value = "/listarUsuarios")
    public ResponseEntity<OutputEntity> listarUsuarios() {
        OutputEntity<List<Usuarios>> out = new OutputEntity<>();
        try {
            List<Usuarios> result = usuariosService.findAll();
            if (result.isEmpty()) {
                out.succes(Response.NOTFOUND.getCode(), Response.NOTFOUND.getKey(), result);

            } else {
                out.succes(Response.OK.getCode(), Response.OK.getKey(), result);
            }
        } catch (Exception e) {
            out.error();

        }
        return new ResponseEntity<>(out, out.getCode());
    }

    //Guardar usuario
//    @SystemControllerLog(operation = "guardarUsuario", type = "Guardo un usuario") //Log de quien ejecuta el metodo
    @PostMapping(value = "/guardarUsuario")
    public ResponseEntity<OutputEntity> guardarUsuario(@RequestBody UsuariosDTO usuarioGuardarDTO) {
        OutputEntity<Usuarios> out = new OutputEntity<>();
        try {
            Usuarios result = usuariosService.save(usuarioGuardarDTO);
            out.succes(Response.CREATED.getCode(), Response.CREATED.getKey(), result);
        } catch (Exception e) {
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

    //Buscar usuario por id
    @GetMapping(value = "/buscarUsuario/{id}")
    public ResponseEntity<OutputEntity> buscarUsuario(@PathVariable Integer id) {
        OutputEntity<Usuarios> out = new OutputEntity<>();
        try {
            Usuarios result = usuariosService.findOne(id);
            out.succes(Response.OK.getCode(), Response.OK.getKey(), result);
        } catch (Exception e) {
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

    //Actualizar datos de usuario
    @PostMapping(value = "/actualizarUsuario/{id}")
    public ResponseEntity<OutputEntity> actualizarUsuario(@RequestBody UsuariosDTO usuario, @PathVariable Integer id) {
        OutputEntity<Usuarios> out = new OutputEntity<>();
        try {
            Usuarios result = usuariosService.updateUsuario(id, usuario);
            out.succes(Response.UPDATE.getCode(), Response.UPDATE.getKey(), result);
        } catch (Exception e) {
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

}
