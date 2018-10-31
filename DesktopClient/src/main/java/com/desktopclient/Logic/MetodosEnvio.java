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
    
    public static String getUrlBase(){
        return urlbase;
    }
    
    public static String getRuta(){
        return ruta;
    }
    
    JsonParser parser = new JsonParser();
    Gson gson = new Gson();
    
    public static String ejecutarGet(String endpoint,String token){
        System.out.println("token: " + token);
        String retSrc = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpGet getRequest = new HttpGet(urlbase+endpoint);
            getRequest.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
            getRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ token);
            response = httpClient.execute(getRequest);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                retSrc = EntityUtils.toString(responseEntity);
                System.out.println(retSrc);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retSrc;
    }
    
    public static String ejecutarPost(String endpoint,String token, HashMap<String,String> parms){
        String output = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            
            HttpPost postRequest = new HttpPost(urlbase+endpoint);
            JsonObject body = new JsonObject();
            for (HashMap.Entry<String,String> parm: parms.entrySet()) {
                String key = parm.getKey();
                String value = parm.getValue();
                body.addProperty(key, value);
            }
            
            StringEntity entity = new StringEntity(body.toString());
            postRequest.setEntity(entity);
            
            if (!token.isEmpty()){
                postRequest.addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+token);
            }
            postRequest.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
            response = httpClient.execute(postRequest);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                //System.out.println(EntityUtils.toString(responseEntity));
               output = EntityUtils.toString(responseEntity);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
    
}
