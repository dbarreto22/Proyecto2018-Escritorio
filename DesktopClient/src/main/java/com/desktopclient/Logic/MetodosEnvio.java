/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.Logic;

import com.desktopclient.entidades.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

/**
 *
 * @author Ernesto
 */
public class MetodosEnvio {
    public void saveNotasCurso(Estudiante_Curso e){
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response; 
            
            HttpPost postRequest = new HttpPost("http://tsi-diego.eastus.cloudapp.azure.com:8080/miudelar-server/bedelia/notasCurso");
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
    }
}
