/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.Logic;

import com.desktopclient.entidades.Carrera;
import com.desktopclient.entidades.Asignatura;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;


/**
 *
 * @author Ernesto
 */
public class Recursos {
    
    public static List<Carrera> getAllCarreras(){
        List<Carrera> carreras = new ArrayList<Carrera>();
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response; 
            
            HttpGet getRequest = new HttpGet("http://tsi-diego.eastus.cloudapp.azure.com:8080/miudelar-server/director/carrera");
            getRequest.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
            response = httpClient.execute(getRequest);
            HttpEntity responseEntity = response.getEntity();
            
            JSONArray jsonArray = new JSONArray();
            
            if (responseEntity != null) {
                jsonArray = new JSONArray(EntityUtils.toString(responseEntity));
            }
            
            for (int i = 0; i < jsonArray.length(); i++) {
                Carrera c = new Carrera();
                c.setCodigo(jsonArray.getJSONObject(i).getLong("codigo"));
                c.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                carreras.add(c);
            }       

            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carreras;
    }
    public static List<Asignatura> getAsignaturasByCarrera(long idCarrera){
        List<Asignatura> asignaturas = new ArrayList<Asignatura>();
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response; 
            
            HttpGet getRequest = new HttpGet("http://tsi-diego.eastus.cloudapp.azure.com:8080/miudelar-server/director/asignatura/carrera/"+idCarrera);
            getRequest.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
            response = httpClient.execute(getRequest);
            HttpEntity responseEntity = response.getEntity();
            
            JSONArray jsonArray = new JSONArray();
            
            if (responseEntity != null) {
                jsonArray = new JSONArray(EntityUtils.toString(responseEntity));
            }
            
            for (int i = 0; i < jsonArray.length(); i++) {
                Asignatura a = new Asignatura();
                a.setCodigo(jsonArray.getJSONObject(i).getLong("codigo"));
                a.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                asignaturas.add(a);
            }       

            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return asignaturas;
    }
}
