/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package paq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author prendamex
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of paq.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
     @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postNuevoUsuario(
            @FormParam("userc") String usuario,
            @FormParam("password") String pass
            ) throws ClassNotFoundException, SQLException, MalformedURLException, IOException {
            String r="";
            String ll="http://localhost:8081/Proyecto/webresources/check/"+usuario;
            URL la= new URL(ll);
           BufferedReader rd= new BufferedReader(new InputStreamReader(la.openStream()));
           String cade="a";
            
           boolean res=false;
        while((cade=rd.readLine())!=null){
               if(cade.equals(pass)){
                   res=true;
               }
        }
        
        rd.close();

        if(res){
   r="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"  <script>\n" +
"    function crea_forma(objeto) {\n" +
"    let res = new FormData( );\n" +
"    for (let campo in objeto) {\n" +
"       res.append(campo, (typeof(objeto[campo]) == 'object' ? JSON.stringify(objeto[campo]) : objeto[campo]));\n" +
"    }\n" +
"    return res;\n" +
" }\n" +
"function llama(l){\n" +
"  login(l);\n" +
"}\n" +
"\n" +
" async  function login(us){\n" +
"       let u=await fetch(\"http://localhost:8080/ProyectoC/js/inicia.php\", {\n" +
"              \"method\": \"POST\",\n" +
"              \"body\": crea_forma({\n" +
"                \"nombre\":us\n" +
"              })\n" +
"          });\n" +
"          console.log(await u.text( ));\n" +
"       //location.href=\"http://localhost:8080/proyectoc/principal.html\";   \n" +
"   }\n" +
"  </script>\n" +
"\n" +
"</head>\n" +
"<body onload=\"llama('"+usuario+"')\">\n" +
"\n" +
"</body>\n" +
"</html>";   
                    }else{
                      r="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"  <script>\n" +
" function login(){\n" +
"         alert(\"paswor incorecto o user \");\n" +
"        location.href=\"http://localhost:8081/Proyecto/\";   \n" +
"   }\n" +
"  </script>\n" +
"\n" +
"</head>\n" +
"<body onload=\"login()\">\n" +
"\n" +
"</body>\n" +
"</html>" ;
 }
                    
            return Response.ok(r ).build(); 
 }
    

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     */
    
}
