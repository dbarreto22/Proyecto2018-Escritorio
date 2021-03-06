/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.Logic;

import com.desktopclient.datatypes.*;
import com.desktopclient.entidades.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;
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
public class MetodosEnvio {
    
    private static String urlbase = "http://localhost:8080/miudelar-server/";
    private static String ruta = "MiUdelar.png";
    private static String token;
    private static int lastStatus;
    
    
    public static String getUrlBase(){
        return urlbase;
    }
    
    public static String getRuta(){
        return ruta;
    }
    
    public static int getLastStatus(){
        return lastStatus;
    }
           
    private static JsonParser parser = new JsonParser();
    
    public static String ejecutarGet(String endpoint){
        String retSrc = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpGet getRequest = new HttpGet(urlbase+endpoint);
            System.out.println("urlbase+endpoint: " + urlbase+endpoint);
            getRequest.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
            getRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ token);
            response = httpClient.execute(getRequest);
            lastStatus = response.getStatusLine().getStatusCode();
            
            if (lastStatus == 200){
                HttpEntity responseEntity = response.getEntity();
            
                if (responseEntity != null) {
                    retSrc = EntityUtils.toString(responseEntity);
                    retSrc = new String(retSrc.getBytes("ISO-8859-1"), "UTF-8");
                }
            }
            
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("retSrc: " + retSrc);
        return retSrc;
    }
    
    public static String ejecutarGetActa(String endpoint){
        String retSrc = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpGet getRequest = new HttpGet(urlbase+endpoint);
            System.out.println("urlbase+endpoint: " + urlbase+endpoint);
            getRequest.addHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN);
            getRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ token);
            response = httpClient.execute(getRequest);
            lastStatus = response.getStatusLine().getStatusCode();
            
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                retSrc = EntityUtils.toString(responseEntity);
                retSrc = new String(retSrc.getBytes("ISO-8859-1"), "UTF-8");
            }
            
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("retSrc: " + retSrc);
        return retSrc;
    }
    
    public static String ejecutarPostParms(String endpoint, HashMap<String,String> parms){
        String output = "";
        System.out.println("token: " +token);
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpPost postRequest = new HttpPost(urlbase+endpoint);
            JsonObject body = new JsonObject();
            for (HashMap.Entry<String,String> parm: parms.entrySet()) {
                String key = parm.getKey();
                String value = parm.getValue();
                body.addProperty(key, value);
                System.out.println("key: " + key);
                System.out.println("value: " + value);
            }
            
            StringEntity entity = new StringEntity(body.toString());
            postRequest.setEntity(entity);
            
            
            if (!token.isEmpty()){
                postRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+token);
            }
            postRequest.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
            response = httpClient.execute(postRequest);
            lastStatus = response.getStatusLine().getStatusCode();
            
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                //System.out.println(EntityUtils.toString(responseEntity));
               output = EntityUtils.toString(responseEntity);
               output = new String(output.getBytes("ISO-8859-1"), "UTF-8");
            }
            
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public static String ejecutarPostObject(String endpoint, JsonObject object){
        String output = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpPost postRequest = new HttpPost(urlbase+endpoint);
            
            System.out.println("object: " + object.toString());
            StringEntity entity = new StringEntity(object.toString());
            postRequest.setEntity(entity);
            
            if (!token.isEmpty()){
                postRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+token);
            }
            postRequest.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
            response = httpClient.execute(postRequest);
            lastStatus = response.getStatusLine().getStatusCode();
            
            if (lastStatus == 200){
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    //System.out.println(EntityUtils.toString(responseEntity));
                   output = EntityUtils.toString(responseEntity);
                   output = new String(output.getBytes("ISO-8859-1"), "UTF-8");
                }
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public static DtUsuarioLogueado login(String cedula,String pass){
        DtUsuario usuario = new DtUsuario();
        DtUsuarioLogueado usuariolog = new DtUsuarioLogueado();
        String output = "";
        
        HashMap<String,String> parms = new HashMap<String,String>();
        parms.put("password", pass);
        parms.put("username", cedula);
        
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            System.out.println("keyStore: " + System.getProperty("javax.net.ssl.keyStore").toString());
            System.out.println("truststore: " + System.getProperty("javax.net.ssl.trustStore").toString());
            
            HttpPost postRequest = new HttpPost(urlbase+"admin/login");
            JsonObject body = new JsonObject();
            for (HashMap.Entry<String,String> parm: parms.entrySet()) {
                String key = parm.getKey();
                String value = parm.getValue();
                body.addProperty(key, value);
            }
            StringEntity entity = new StringEntity(body.toString());
            postRequest.setEntity(entity);
            
            postRequest.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
            response = httpClient.execute(postRequest);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                //System.out.println(EntityUtils.toString(responseEntity));
               output = EntityUtils.toString(responseEntity);
               output = new String(output.getBytes("ISO-8859-1"), "UTF-8");
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        usuariolog.setToken(output);
        usuario.setCedula(cedula);
        usuario.setPassword(pass);
        usuariolog.setUsuario(usuario);
        System.out.println("output: " + output);
        token = output;
            
        return usuariolog;
    } 
    
}
