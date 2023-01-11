/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ClienteOMDBApi 
{
    public static List<String> obtieneGeneros() throws ParseException 
    {
        List<String> generos = new ArrayList();
        String movieId = "";
        for(int i=100; i<600; i++)
        {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/").queryParam("i", movieId).queryParam("apikey", "208a05f2");
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

            String genero = (String) responseJSON.get("Genre");
            if(genero!=null&&!genero.equals("N/A")){
                 System.out.println("\n generos " + genero);
                 StringTokenizer tokens = new StringTokenizer(genero,",");
                 while(tokens.hasMoreTokens())
                 generos.add(tokens.nextToken());
            }
        }
        return generos;
    }
    public static List<AbstractMap.SimpleEntry<String, String>> obtienePeliculas() throws ParseException 
    {
        
        List<AbstractMap.SimpleEntry<String, String>> pelis = new ArrayList();
        String movieId = "";
        for(int i=100; i<600; i++)
        {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/").queryParam("i", movieId).queryParam("apikey", "208a05f2");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

        String peli = (String) responseJSON.get("Title");
        String pos=(String) responseJSON.get("Poster");
        if(peli!=null&&!peli.equals("N/A")&&!pos.equals("N/A")){
          System.out.println("\n pelis" + peli);
          AbstractMap.SimpleEntry<String, String> entry  = new AbstractMap.SimpleEntry<>(movieId , peli);
          pelis.add(entry);
           }
        }
        return pelis;
    }
    
    public static List<String> obtieneDir() throws ParseException 
    {
        List<String> dir = new ArrayList();
        String movieId = "";
        for(int i=100; i<600; i++){
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/").queryParam("i", movieId).queryParam("apikey", "208a05f2");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

        String dire = (String) responseJSON.get("Director");
        if(dire!=null&&!dire.equals("N/A"))
        {
          System.out.println("\n Dire " + dire);
          StringTokenizer tokens = new StringTokenizer(dire,",");
          while(tokens.hasMoreTokens())
              dir.add(tokens.nextToken());
        }
        }
        return dir;
    }
    public static List<String> obtieneActores() throws ParseException 
    {
        List<String> actores = new ArrayList();
        String movieId = "";
        for(int i=100; i<600; i++)
        {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/").queryParam("i", movieId).queryParam("apikey", "208a05f2");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

        String cadaActor = (String) responseJSON.get("Actors");
        if(cadaActor!=null&&!cadaActor.equals("N/A"))
        {
          System.out.println("\n Actores " + cadaActor);
          StringTokenizer tokens = new StringTokenizer(cadaActor,",");
          while(tokens.hasMoreTokens())
              actores.add(tokens.nextToken());
        }
        }
        return actores;
    }
    
    
}
