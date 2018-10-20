/**
 * This file was generated by the JPA Modeler
 */
package com.desktopclient.datatypes;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DtRol implements Serializable {

    private Long id;

    private String tipo;

    public DtRol(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public DtRol() {
    }

    public DtRol(String tipo) {
        this.tipo = tipo;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final DtRol other = (DtRol) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
