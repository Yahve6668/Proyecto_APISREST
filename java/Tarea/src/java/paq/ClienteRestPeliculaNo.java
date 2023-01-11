/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author prendamex
 */
public class ClienteRestPeliculaNo {
    public static Pelicula InfoPeli(String id) throws org.json.simple.parser.ParseException{
        Pelicula e=new Pelicula();
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target("http://www.omdbapi.com/")
                .queryParam("i", id)
                .queryParam("apikey", "208a05f2");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());

        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));
            String titulo = (String) responseJSON.get("Title");
            String anio = (String) responseJSON.get("Year");
            String poster = (String) responseJSON.get("Poster");
            String categoria=(String)responseJSON.get("Rated");
            String duracion=(String)responseJSON.get("Runtime");
            String fehcal=(String)responseJSON.get("Released");
            String actors=(String)responseJSON.get("Actors");
            String director=(String)responseJSON.get("Director");
            String domina=(String)responseJSON.get("Awards");
            String idd=(String)responseJSON.get("imdbId");
            String des=(String)responseJSON.get("Plot");
            e=new Pelicula(titulo, anio, poster,categoria,duracion,fehcal,actors,director,domina,idd,des);
            //System.out.println("\n Titulo " + titulo + " año " + anio + " poster " + poster);
        
        
        return e;
    }
    public static ArrayList<Pelicula> peliculasPorTema(String tema) throws org.json.simple.parser.ParseException{
        
       ArrayList<Pelicula> Maches = new ArrayList();
        
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target("http://www.omdbapi.com/")
                .queryParam("s", tema)
                .queryParam("apikey", "92bba147");
        
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());

        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

        JSONArray peliculas = (JSONArray) responseJSON.get("Search");
        for (Iterator it = peliculas.iterator(); it.hasNext();) {
            Object pelicula = it.next();
            JSONObject cadaPelicula = (JSONObject) pelicula;
            String titulo = (String) cadaPelicula.get("Title");
            String anio = (String) cadaPelicula.get("Year");
            String poster = (String) cadaPelicula.get("Poster");
            String categoria=(String)cadaPelicula.get("Rated");
            String duracion=(String)cadaPelicula.get("Runtime");
            String fehcal=(String)cadaPelicula.get("Released");
            String act=(String)cadaPelicula.get("Actors");
            String director=(String)cadaPelicula.get("Director");
            String domina=(String)cadaPelicula.get("Awards");
            String idd=(String)cadaPelicula.get("imdbID");
            String des=(String)cadaPelicula.get("Plot");
            Maches.add(new Pelicula(titulo, anio, poster,categoria,duracion,fehcal,act,director,domina,idd,des));
            //System.out.println("\n Titulo " + titulo + " año " + anio + " poster " + poster);
        }
        return Maches;  
    }
    
}
