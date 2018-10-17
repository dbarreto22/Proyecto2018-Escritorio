/**
 * This file was generated by the JPA Modeler
 */
package Entidades;

import java.io.Serializable;
import java.util.List;

/**
 * @author Windows XP
 */
public class Carrera implements Serializable {

    private Long codigo;

    private String nombre;

    private List<Asignatura_Carrera> asignatura_Carreras;

    private List<Usuario> usuarios;

    private List<Periodo_Examen> periodos_Examenes;

    private List<Asignatura> asignaturas;

    public Carrera(Long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Carrera() {
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura_Carrera> getAsignatura_Carreras() {
        return this.asignatura_Carreras;
    }

    public void setAsignatura_Carreras(List<Asignatura_Carrera> asignatura_Carreras) {
        this.asignatura_Carreras = asignatura_Carreras;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Periodo_Examen> getPeriodos_Examenes() {
        return this.periodos_Examenes;
    }

    public void setPeriodos_Examenes(List<Periodo_Examen> periodos_Examenes) {
        this.periodos_Examenes = periodos_Examenes;
    }

    public List<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

}