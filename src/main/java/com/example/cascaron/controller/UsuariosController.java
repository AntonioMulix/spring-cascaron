/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.controller;

import com.example.cascaron.dto.UsuarioDTO;
import com.example.cascaron.config.SystemControllerLog;
import com.example.cascaron.dto.UsuarioGuardarDTO;
import com.example.cascaron.entity.Usuario;
import com.example.cascaron.entity.UsuarioRol;
import com.example.cascaron.exception.OutputEntity;
import com.example.cascaron.service.UsuarioRolService;
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
import com.example.cascaron.service.UsuarioService;
import org.springframework.http.HttpStatus;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuariosService;

    @Autowired
    private UsuarioRolService usuarioRolService;

    //Busca a todos los usuarios activos y no activos
    @SystemControllerLog(operation = "listarUsuarios", type = "obtuvo lista de todos los  usuarios") //Log de quien ejecuta el metodo
    @GetMapping(value = "/listarUsuarios")
    public ResponseEntity<OutputEntity> listarUsuarios() {
        OutputEntity<List<Usuario>> out = new OutputEntity<>();
        try {
            List<Usuario> result = usuariosService.findAll();
            if (result.isEmpty()) {
                out.success(Response.NOTFOUND.getCode(), Response.NOTFOUND.getKey(), result);

            } else {
                out.success(Response.OK.getCode(), Response.OK.getKey(), result);
            }
        } catch (Exception e) {
            out.error();

        }
        return new ResponseEntity<>(out, out.getCode());
    }

    //Guardar usuario
//    @SystemControllerLog(operation = "guardarUsuario", type = "Guardo un usuario") //Log de quien ejecuta el metodo
    @PostMapping(value = "/guardarUsuario")
    public ResponseEntity<OutputEntity> guardarUsuario(@RequestBody UsuarioGuardarDTO usuarioDTO) {
        OutputEntity<Usuario> out = new OutputEntity<>();
        try {
            Usuario result = usuariosService.save(usuarioDTO);
            out.success(Response.CREATED.getCode(), Response.CREATED.getKey(), result);
        } catch (Exception e) {
            System.out.println("Entro en el error de guardado: " + e);
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

    //Buscar usuario por id
    @GetMapping(value = "/buscarUsuario/{id}")
    public ResponseEntity<OutputEntity> buscarUsuario(@PathVariable Integer id) {
        OutputEntity<Usuario> out = new OutputEntity<>();
        try {
            Usuario result = usuariosService.findOne(id);
            out.success(Response.OK.getCode(), Response.OK.getKey(), result);
        } catch (Exception e) {
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

    //Actualizar datos de usuario
    @PostMapping(value = "/actualizarUsuario/{id}")
    public ResponseEntity<OutputEntity> actualizarUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id) {
        OutputEntity<Usuario> out = new OutputEntity<>();
        try {
            Usuario result = usuariosService.updateUsuario(id, usuario);
            out.success(Response.UPDATE.getCode(), Response.UPDATE.getKey(), result);
        } catch (Exception e) {
            out.error();
        }
        return new ResponseEntity<>(out, out.getCode());
    }

    /*
     * ************************************************************************
     * UsuarioRol
     * ************************************************************************
     */
    //Asignar roles a usuario Buscar ID de Usuario y ID del Catalogo de Roles
    @PostMapping(value = "/asignarRoles")
    public ResponseEntity<UsuarioRol> asigarRolesUsuario(@RequestBody UsuarioRol usuarioRol) {
        try {
            return new ResponseEntity<>(usuarioRolService.save(usuarioRol), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //************************ ROLES************************************************
    @PostMapping(value = "/guardarUsuarioRol")
    public ResponseEntity<OutputEntity<String>> guardarRolUsuario(@RequestBody UsuarioRol usuarioRol) {
        OutputEntity<String> out = new OutputEntity<>();
        try {
            usuarioRolService.save(usuarioRol);
            out.success(Response.CREATED.getCode(), Response.CREATED.getKey(), "Rol Asignado");
            return new ResponseEntity<>(out, out.getCode());

        } catch (Exception e) {
            out.error();
            System.out.println("usuario rol " + usuarioRol.getUsuarioId() + e);
            return new ResponseEntity<>(out, out.getCode());
        }
    }

    //************************ BORRAR ROL **************************************
    @PostMapping(value = "/eliminarRol/{usuarioId}/{rolId}")
    public ResponseEntity<OutputEntity<Integer>> eliminarRol(@RequestBody @PathVariable("usuarioId") Long usuarioId, @PathVariable("rolId") Long rolId) {
        OutputEntity<Integer> out = new OutputEntity<>();
        try {
            usuarioRolService.deleteRol(usuarioId, rolId);
            out.success(Response.DELETED.getCode(), Response.DELETED.getKey(), null);
            return ResponseEntity.ok(out);
        } catch (Exception e) {
            out.error();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
