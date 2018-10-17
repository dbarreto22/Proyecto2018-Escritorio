/**
 * This file was generated by the JPA Modeler
 */
package Entidades;

import java.io.Serializable;

/**
 * @author Windows XP
 */
public class Periodo_Examen implements Serializable {

    private Long id;

    private String tipo;

    private String fechaInicio;

    private String fechaFin;

    public Periodo_Examen(Long id, String tipo, String fechaInicio, String fechaFin) {
        this.id = id;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Periodo_Examen() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}