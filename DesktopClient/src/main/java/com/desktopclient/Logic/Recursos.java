/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.Logic;

import com.desktopclient.datatypes.DtAsignatura_Carrera;
import com.desktopclient.datatypes.DtCarrera;
import com.desktopclient.datatypes.DtCurso;
import com.desktopclient.datatypes.DtUsuario;
import com.desktopclient.datatypes.DtUsuarioLogueado;
import com.desktopclient.entidades.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Ernesto
 */
public class Recursos {
    
    static JsonParser parser = new JsonParser();
    static Gson gson = new Gson();
    
    public StaticTableModel staticTableModelBuilder(String[] headers, List<Object[]> data) {
        StaticTableModel m = new StaticTableModel();
        for (String h : headers) {
            m.addColumn(h);
        }
        data.forEach((c) -> {
            m.addRow(c);
        });
        return m;
    }
    
    public JTable tableConfig(JTable t, String[] tableHeaders, List<Object[]> data, int selectionMode) {
        t.setModel(this.staticTableModelBuilder(tableHeaders, data));
        t.setSelectionMode(selectionMode);
        return t;
    }
    
    
    public static List<DtCarrera> getAllCarreras(String token){
        System.out.println("getAllCarreras");
//        List<DtCarrera> carreras = new ArrayList<DtCarrera>();
        String response = MetodosEnvio.ejecutarGet("director/carrera",token);
        
        DtCarrera[] mcArray = gson.fromJson(response, DtCarrera[].class);
        List<DtCarrera> carreras = Arrays.asList(mcArray);
        return carreras;
    }
    
    public static List<DtAsignatura_Carrera> getAllAsignaturaCarrera(String token){
        String response = MetodosEnvio.ejecutarGet("director/asignaturacarrera",token);
        
        DtAsignatura_Carrera[] mcArray = gson.fromJson(response, DtAsignatura_Carrera[].class);
        List<DtAsignatura_Carrera> asig_car = Arrays.asList(mcArray);
        return asig_car;
    }
    
    public static List<DtCurso> getAllCursos(String token){
        String response = MetodosEnvio.ejecutarGet("estudiante/curso",token);
        
        DtCurso[] mcArray = gson.fromJson(response, DtCurso[].class);
        List<DtCurso> curso = Arrays.asList(mcArray);
        return curso;
    }
//    
//    public static List<Asignatura> getAsignaturasByCarrera(long idCarrera,String token) {
//        List<Asignatura> asignaturas = new ArrayList<Asignatura>();
//        JSONArray jsonArray = MetodosEnvio.ejecutarGet("director/asignatura/carrera/"+idCarrera,token);
//        for (int i = 0; i < jsonArray.length(); i++) {
//            Asignatura a = new Asignatura();
//            a.setCodigo(jsonArray.getJSONObject(i).getLong("codigo"));
//            a.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
//            asignaturas.add(a);        
//        }
//        return asignaturas;
//    }
//    public static List<Curso> getCursosBynC_nA(String nombreCarrera,String nombreAsignatura,String token) {
//        List<Curso> cursos = new ArrayList<Curso>();
//        //List<Horario> horariosCurso = new ArrayList<Horario>();
//        Curso c = new Curso();
//        JSONArray jsonArray = MetodosEnvio.ejecutarGet("director/asignaturacarrera",token);
//        JSONArray cursosJSon = null;
//        for (int i = 0;i < jsonArray.length(); i++) {
//            String carrera = jsonArray.getJSONObject(i).getJSONObject("carrera").getString("nombre");
//            String asignatura = jsonArray.getJSONObject(i).getJSONObject("asignatura").getString("nombre");
//            if (carrera.equals(nombreCarrera) && asignatura.equals(nombreAsignatura)) {
//                cursosJSon = jsonArray.getJSONObject(i).getJSONArray("cursos");
//                break;
//            }
//        }
//        for (int i = 0;i < cursosJSon.length(); i++) {
//            c.setId(cursosJSon.getJSONObject(i).getLong("id"));
//            c.setFecha(new Date(cursosJSon.getJSONObject(i).getLong("fecha")));
//            cursos.add(c);
//        }
//        return cursos;
//    }
    
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
    
    public static DtUsuarioLogueado login(String cedula,String pass){
        
        DtUsuario usuario = new DtUsuario();
        DtUsuarioLogueado usuariolog = new DtUsuarioLogueado();
        
        HashMap<String,String> parms = new HashMap<String,String>();
        parms.put("password", pass);
        parms.put("username", cedula);
        
        String response = MetodosEnvio.ejecutarPost("admin/login", "", parms);

        usuariolog.setToken(response);
        usuario.setCedula(cedula);
        usuario.setPassword(pass);
        usuariolog.setUsuario(usuario);
            
        return usuariolog;
    } 
 /*   public void saveNotasCurso(Estudiante_Curso e){
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
    }*/
}
