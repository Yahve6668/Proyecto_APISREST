/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package paq;

import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author prendamex
 */
@Path("check")
public class CheckResource {

    @Context
    private UriInfo context;
    private static String idUsuario = "";
    private static Map<String,String> listaUsuarios2 = new ConcurrentHashMap<String,String>();
    private static ArrayList<Map.Entry<String,String>> listaUsuarios= new ArrayList();
    /**
     * Creates a new instance of CheckResource
     */
    public CheckResource() {
    }

    /**
     * Retrieves representation of an instance of paq.CheckResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHtml() throws ClassNotFoundException {
        listaUsuarios = operBD.cargaListaUsuarios();   
        String res="{";
       int l=0;
        for(Map.Entry<String,String>a : listaUsuarios){
            res+='"';
            res+=a.getKey();
            res+='"'+":"+'"';
            res+=a.getValue();
            res+='"';
            if(l<listaUsuarios.size()-1){
            res+=",";
            }
            ++l;
        }
        res+="}";
        return res;
    }

        
    @GET
    @Path("{idUsuario}")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(@PathParam("idUsuario") String idUsuario) 
    {
        String usu = "";
        for(Map.Entry<String,String>a : listaUsuarios){
            if(a.getKey().equals(idUsuario)){
                usu=a.getValue();
                break;
            }
        }
        if (usu == null) 
        {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return usu;
    }
    
 @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postNuevoUsuario(
            @FormParam("name") String nombre,
            @FormParam("userc") String usuario,
            @FormParam("old") int edad,  
            @FormParam("gender") String genero,
            @FormParam("email")String corre,
            @FormParam("password") String pass
            ) throws ClassNotFoundException, SQLException {
            String r=nombre;
           
            String l=operBD.responNue(usuario, nombre,genero,pass,corre,edad);
            
            if(l.equals("false")){
              r="<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Refresh\" content=\"5;url=http://localhost:8081/Proyecto/\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>El nombre de usuario ya fue ocupado intenta otro</p>\n" +
                "</body>\n" +
                "</html>";
            }else{
              r="<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Refresh\" content=\"5;url=http://localhost:8080/proyectoc/registro.html\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>Registro exitoso</p>\n" +
                "</body>\n" +
                "</html>";
            }
       	return Response.ok(r + ":)").build();
    }
    /**
     * PUT method for updating or creating an instance of CheckResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
