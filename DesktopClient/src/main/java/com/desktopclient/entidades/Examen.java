/**
 * This file was generated by the JPA Modeler
 */
package com.desktopclient.entidades;

import com.desktopclient.datatypes.DtAsignatura;
import com.desktopclient.datatypes.DtAsignatura_Carrera;
import com.desktopclient.datatypes.DtCarrera;
import com.desktopclient.datatypes.DtExamen;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * @author Windows XP
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@Entity
//@NamedQueries({
//    @NamedQuery(name = "Examen.findAll", query = "Select e from Examen e"),
//    @NamedQuery(name = "Examen.findByFecha", query = "Select e from Examen e where e.fecha=:fecha")})
public class Examen implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Basic
    private Date fecha;

    @XmlTransient
//    @ManyToOne(targetEntity = Asignatura_Carrera.class)
    private Asignatura_Carrera asignatura_Carrera;

    @XmlTransient
//    @OneToMany(targetEntity = Estudiante_Examen.class, fetch = FetchType.EAGER)
    private List<Estudiante_Examen> calificacionesExamenes;


  public Examen(Long id, java.util.Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Examen(DtExamen examen) {
        this.fecha = examen.getFecha();
        this.asignatura_Carrera = new Asignatura_Carrera(examen.getAsignatura_Carrera().getAsignatura(), examen.getAsignatura_Carrera().getCarrera());
    }
    
    public Examen() {
    }

    public Examen(java.util.Date fecha, Asignatura_Carrera asignatura_Carrera) {
        this.fecha = fecha;
        this.asignatura_Carrera = asignatura_Carrera;
    }

    public Examen(Long id, java.util.Date fecha, Asignatura_Carrera asignatura_Carrera) {
        this.id = id;
        this.fecha = fecha;
        this.asignatura_Carrera = asignatura_Carrera;
    }

    public Examen(Long id, java.util.Date fecha, Asignatura_Carrera asignatura_Carrera, List<Estudiante_Examen> calificacionesExamenes) {
        this.id = id;
        this.fecha = fecha;
        this.asignatura_Carrera = asignatura_Carrera;
        this.calificacionesExamenes = calificacionesExamenes;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getFecha() {
        return this.fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public Asignatura_Carrera getAsignatura_Carrera() {
        return this.asignatura_Carrera;
    }

    public void setAsignatura_Carrera(Asignatura_Carrera asignatura_Carrera) {
        this.asignatura_Carrera = asignatura_Carrera;
    }

//    public List<Estudiante_Examen> getCalificacionesExamenes() {
//        return this.calificacionesExamenes;
//    }
//
//    public void setCalificacionesExamenes(List<Estudiante_Examen> calificacionesExamenes) {
//        this.calificacionesExamenes = calificacionesExamenes;
//    }
    
    public DtExamen toDataType(){
        DtAsignatura_Carrera asignatura_Carrera = new DtAsignatura_Carrera(this.asignatura_Carrera.getId(),
                new DtCarrera(this.asignatura_Carrera.getCarrera().getCodigo(), this.asignatura_Carrera.getCarrera().getNombre()),
                new DtAsignatura(this.asignatura_Carrera.getAsignatura().getCodigo(), this.asignatura_Carrera.getAsignatura().getNombre())
        );
        return new DtExamen(this.id, this.fecha, asignatura_Carrera);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Examen other = (Examen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
