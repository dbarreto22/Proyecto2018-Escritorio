/**
 * This file was generated by the JPA Modeler
 */
package com.desktopclient.datatypes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class DtExamen implements Serializable {

    private Long id;

    private Date fecha;

    private DtAsignatura_Carrera asignatura_Carrera;

    private List<DtEstudiante_Examen> calificacionesExamenes;

    private List<DtUsuario> inscriptos;

    public DtExamen(Long id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public DtExamen() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DtAsignatura_Carrera getAsignatura_Carrera() {
        return this.asignatura_Carrera;
    }

    public void setAsignatura_Carrera(DtAsignatura_Carrera asignatura_Carrera) {
        this.asignatura_Carrera = asignatura_Carrera;
    }

    public List<DtEstudiante_Examen> getCalificacionesExamenes() {
        return this.calificacionesExamenes;
    }

    public void setCalificacionesExamenes(List<DtEstudiante_Examen> calificacionesExamenes) {
        this.calificacionesExamenes = calificacionesExamenes;
    }

    public List<DtUsuario> getInscriptos() {
        return this.inscriptos;
    }

    public void setInscriptos(List<DtUsuario> inscriptos) {
        this.inscriptos = inscriptos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DtExamen other = (DtExamen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
