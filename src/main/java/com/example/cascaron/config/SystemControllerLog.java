/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.cascaron.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author marco-romero
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})// La posición de destino de la anotación, METHOD se puede anotar a nivel de método
@Retention(RetentionPolicy.RUNTIME) // En qué etapa se ejecuta la anotación
@Documented// Generar documentación
public @interface SystemControllerLog {

    String operation() default "";

    String type();
}
