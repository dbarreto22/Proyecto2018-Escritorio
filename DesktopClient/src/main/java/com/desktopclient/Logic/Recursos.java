/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.Logic;

import com.desktopclient.datatypes.*;
import com.desktopclient.entidades.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
    
    private static String urlbase = "http://tsi-diego.eastus.cloudapp.azure.com:8080/miudelar-server/";
    
    public static JSONArray ejecutarRequest(String endpoint,String token){
        JSONArray jsonArray = new JSONArray();
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpGet getRequest = new HttpGet(urlbase+endpoint);
            getRequest.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
            getRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+token);
            response = httpClient.execute(getRequest);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                //System.out.println(EntityUtils.toString(responseEntity));
                jsonArray = new JSONArray(EntityUtils.toString(responseEntity));
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
            
    public static List<Carrera> getAllCarreras(String token){
        List<Carrera> carreras = new ArrayList<Carrera>();
        JSONArray jsonArray = ejecutarRequest("director/carrera",token);
        for (int i = 0; i < jsonArray.length(); i++) {
            Carrera c = new Carrera();
            c.setCodigo(jsonArray.getJSONObject(i).getLong("codigo"));
            c.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
            carreras.add(c);
        }
        return carreras;
    }
    
    public static List<Asignatura> getAsignaturasByCarrera(long idCarrera,String token) {
        List<Asignatura> asignaturas = new ArrayList<Asignatura>();
        JSONArray jsonArray = ejecutarRequest("director/asignatura/carrera/"+idCarrera,token);
        for (int i = 0; i < jsonArray.length(); i++) {
            Asignatura a = new Asignatura();
            a.setCodigo(jsonArray.getJSONObject(i).getLong("codigo"));
            a.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
            asignaturas.add(a);        
        }
        return asignaturas;
    }
    public static List<Curso> getCursosBynC_nA(String nombreCarrera,String nombreAsignatura,String token) {
        List<Curso> cursos = new ArrayList<Curso>();
        //List<Horario> horariosCurso = new ArrayList<Horario>();
        Curso c = new Curso();
        JSONArray jsonArray = ejecutarRequest("director/asignaturacarrera",token);
        JSONArray cursosJSon = null;
        for (int i = 0;i < jsonArray.length(); i++) {
            String carrera = jsonArray.getJSONObject(i).getJSONObject("carrera").getString("nombre");
            String asignatura = jsonArray.getJSONObject(i).getJSONObject("asignatura").getString("nombre");
            if (carrera.equals(nombreCarrera) && asignatura.equals(nombreAsignatura)) {
                cursosJSon = jsonArray.getJSONObject(i).getJSONArray("cursos");
                break;
            }
        }
        for (int i = 0;i < cursosJSon.length(); i++) {
            c.setId(cursosJSon.getJSONObject(i).getLong("id"));
            c.setFecha(new Date(cursosJSon.getJSONObject(i).getLong("fecha")));
            cursos.add(c);
        }
        return cursos;
    }
    
    /*public static List<Estudiante_Curso> getEstudiantesByCurso(long idCurso,String token) {
        List<Estudiante_Curso> ecs = new ArrayList<Estudiante_Curso>();
        JSONArray jsonArray = ejecutarRequest("bedelia/estudiantesCurso/"+idCurso,token);
        for (int i = 0; i < jsonArray.length(); i++) {
            Estudiante_Curso ec = new Estudiante_Curso();
            ec.setCedula(jsonArray.getJSONObject(i).getString("cedula"));
            ec.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
            ec.setApellido(jsonArray.getJSONObject(i).getString("apellido"));
            
            asignaturas.add(a);        
        }
        return asignaturas;
    }
*/
    
    
}
