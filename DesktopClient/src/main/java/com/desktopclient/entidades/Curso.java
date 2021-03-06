/**
 * This file was generated by the JPA Modeler
 */
package com.desktopclient.entidades;


import com.desktopclient.datatypes.DtAsignatura;
import com.desktopclient.datatypes.DtAsignatura_Carrera;
import com.desktopclient.datatypes.DtCarrera;
import com.desktopclient.datatypes.DtCurso;
import com.desktopclient.datatypes.DtHorario;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * @author Windows XP
 */
//@XmlAccessorType(XmlAccessType.FIELD)
public class Curso implements Serializable {

    private Long id;
    
    private Date fecha;

    @XmlTransient
    private Asignatura_Carrera asignatura_Carrera;

    private List<Horario> horarios;

    @XmlTransient
    private List<Estudiante_Curso> calificacionesCursos;
    
    
 public Curso(Long id) {
        this.id = id;
    }

    public Curso(Date fecha, Asignatura_Carrera asignatura_Carrera) {
        this.fecha = fecha;
        this.asignatura_Carrera = asignatura_Carrera;
    }

    public Curso(Long id, Date fecha, Asignatura_Carrera asignatura_Carrera, List<Horario> horarios, List<Estudiante_Curso> calificacionesCursos) {
        this.id = id;
        this.fecha = fecha;
        this.asignatura_Carrera = asignatura_Carrera;
        this.horarios = horarios;
        this.calificacionesCursos = calificacionesCursos;
    }
    
    public Curso(Long id, Date fecha, Asignatura_Carrera asignatura_Carrera) {
        this.id = id;
        this.fecha = fecha;
        this.asignatura_Carrera = asignatura_Carrera;
    }
    
    public Curso(DtCurso curso) {
        this.fecha = curso.getFecha();
        Asignatura_Carrera asig_carrera = new Asignatura_Carrera(curso.getAsignatura_Carrera().getAsignatura(), curso.getAsignatura_Carrera().getCarrera()); 
        this.asignatura_Carrera = asig_carrera;
    }

    public Curso() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Horario> getHorarios() {
        return this.horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Asignatura_Carrera getAsignatura_Carrera() {
        return asignatura_Carrera;
    }

    public void setAsignatura_Carrera(Asignatura_Carrera asignatura_Carrera) {
        this.asignatura_Carrera = asignatura_Carrera;
    }
//
//    public List<Estudiante_Curso> getCalificacionesCursos() {
//        return this.calificacionesCursos;
//    }
//
//    public void setCalificacionesCursos(List<Estudiante_Curso> calificacionesCursos) {
//        this.calificacionesCursos = calificacionesCursos;
//    }

    public void addHorario (Horario horario){
        this.horarios.add(horario);
    }
    
    public void removeHorario (Horario horario){
        this.horarios.remove(horario);
    }
    
    public DtCurso toDataType(){
        DtAsignatura_Carrera asignatura_Carrera = new DtAsignatura_Carrera(this.asignatura_Carrera.getId(),
                new DtCarrera(this.asignatura_Carrera.getCarrera().getCodigo(), this.asignatura_Carrera.getCarrera().getNombre()),
                new DtAsignatura(this.asignatura_Carrera.getAsignatura().getCodigo(), this.asignatura_Carrera.getAsignatura().getNombre())
        );
        List <DtHorario> dthorarios = new ArrayList<DtHorario>();
        this.horarios.forEach(horario -> {
            dthorarios.add(new DtHorario(horario.getDia(), horario.getHoraInicio(), horario.getHoraFin()));
        });
        DtCurso dtcurso = new DtCurso(id, fecha, asignatura_Carrera, dthorarios);
        return dtcurso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}