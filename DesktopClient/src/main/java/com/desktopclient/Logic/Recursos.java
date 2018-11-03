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
import com.desktopclient.datatypes.DtExamen;
import com.desktopclient.entidades.Curso;
import com.desktopclient.entidades.Examen;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
    
    public static List<DtAsignatura_Carrera> getAsignaturaCarreraByCarrera(Long idCarrera){
        String response = MetodosEnvio.ejecutarGet("bedelia/asignaturaCarrera/" + idCarrera);
        
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
    
    public static List<DtExamen> getAllExamenes(){
        String response = MetodosEnvio.ejecutarGet("estudiante/examen");
        
        DtExamen[] mcArray = gson.fromJson(response, DtExamen[].class);
        List<DtExamen> examen = Arrays.asList(mcArray);
        return examen;
    }
    
    public static Curso getCurso(Long idCurso){
        String response = MetodosEnvio.ejecutarGet("bedelia/curso/" + idCurso);
        
        Curso curso = gson.fromJson(response, Curso.class);
        return curso;
    }
    
       public static Examen getExamen(Long idExamen){
        String response = MetodosEnvio.ejecutarGet("bedelia/examen/" + idExamen);
        
        Examen examen = gson.fromJson(response, Examen.class);
        return examen;
    }
       
    public static List<DtUsuario> getEstudiantesInscriptosCurso(Long idCurso){
        String response = MetodosEnvio.ejecutarGet("bedelia/estudiantesCurso/" + idCurso);
        
        DtUsuario[] mcArray = gson.fromJson(response, DtUsuario[].class);
        List<DtUsuario> usuarios = Arrays.asList(mcArray);
        return usuarios;
    }  
    
    public static List<DtUsuario> getEstudiantesInscriptosExamen(Long idExamen){
        String response = MetodosEnvio.ejecutarGet("bedelia/estudiantesExamen/" + idExamen);
        
        DtUsuario[] mcArray = gson.fromJson(response, DtUsuario[].class);
        List<DtUsuario> usuarios = Arrays.asList(mcArray);
        return usuarios;
    }
    
    public static String saveCurso(Long idCurso, Date fecha, Long idAsigCar){
        String dateS = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(fecha);
        
        HashMap<String,String> parms = new HashMap<String,String>();
        if(idCurso == null){
            parms.put("idCurso", "0");
        }else{
            parms.put("idCurso", idCurso.toString());
        }
        parms.put("fecha", dateS);
        parms.put("idAsigCar", idAsigCar.toString());
        
        String response = MetodosEnvio.ejecutarPostParms("bedelia/curso", parms);
        return response;
    } 
    
    public static String saveExamen(Long idExamen, Date fecha, Long idAsigCar){
        String dateS = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(fecha);
        
        HashMap<String,String> parms = new HashMap<String,String>();
        if(idExamen == null){
            parms.put("idExamen", "0");
        }else{
            parms.put("idExamen", idExamen.toString());
        }
        parms.put("fecha", dateS);
        parms.put("idAsigCar", idAsigCar.toString());
        
        String response = MetodosEnvio.ejecutarPostParms("bedelia/examen", parms);
        return response;
    } 

    public static String removeCurso(Long idCurso){
        HashMap<String,String> parms = new HashMap<String,String>();
        parms.put("idCurso", idCurso.toString());
        
        String response = MetodosEnvio.ejecutarPostParms("bedelia/removecurso", parms);
        
        return response;
    } 
    
    public static String removeExamen(Long idExamen){
        HashMap<String,String> parms = new HashMap<String,String>();
        parms.put("idExamen", idExamen.toString());
        
        String response = MetodosEnvio.ejecutarPostParms("bedelia/removeexamen", parms);
        
        return response;
    } 
    
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
