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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import com.desktopclient.Logic.ImprovedDateTypeAdapter;

/**
 *
 * @author Ernesto
 */
public class Recursos {
    
    private static JsonParser parser = new JsonParser();
    private static GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new ImprovedDateTypeAdapter()); 
// Register an adapter to manage the date types as long values 
    private static Gson gson = builder.create();
    
    
    public static List<DtCarrera> getAllCarreras(){
        System.out.println("getAllCarreras");
//        List<DtCarrera> carreras = new ArrayList<DtCarrera>();
        String response = MetodosEnvio.ejecutarGet("director/carrera");
        
        DtCarrera[] mcArray = gson.fromJson(response, DtCarrera[].class);
        List<DtCarrera> carreras = Arrays.asList(mcArray);
        return carreras;
    }
    
    public static List<DtAsignatura_Carrera> getAllAsignaturaCarrera(){
        String response = MetodosEnvio.ejecutarGet("director/asignaturacarrera");
        
        DtAsignatura_Carrera[] mcArray = gson.fromJson(response, DtAsignatura_Carrera[].class);
        List<DtAsignatura_Carrera> asig_car = Arrays.asList(mcArray);
        return asig_car;
    }
    
    public static List<DtCurso> getAllCursos(){
        String response = MetodosEnvio.ejecutarGet("estudiante/curso");
        
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
