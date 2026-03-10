/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "usuarios_roles")
public class UsuarioRol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @NotEmpty
    @Column(name = "rol_id")
    private Integer rolId;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer id, Integer usuarioId, Integer rolId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.rolId = rolId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public Integer getRolId() {
        return rolId;
    }
}
