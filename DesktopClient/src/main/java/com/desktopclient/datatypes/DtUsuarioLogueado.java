/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.datatypes;

import java.io.Serializable;

/**
 *
 * @author Ernesto
 */
public class DtUsuarioLogueado implements Serializable {
    
    private DtUsuario usuario;
    
    private String token;

    public DtUsuarioLogueado() {
    }

    public DtUsuarioLogueado(DtUsuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public DtUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DtUsuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}