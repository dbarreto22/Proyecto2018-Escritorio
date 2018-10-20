/**
 * This file was generated by the JPA Modeler
 */
package com.desktopclient.entidades;

import java.io.Serializable;

/**
 * @author Windows XP
 */
public class Estudiante_Curso implements Serializable {

    private Long id;

    private Long calificacion;

    private Usuario usuario;

    private Curso curso;

    public Estudiante_Curso(Long id, Long calificacion) {
        this.id = id;
        this.calificacion = calificacion;
    }

    public Estudiante_Curso() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}