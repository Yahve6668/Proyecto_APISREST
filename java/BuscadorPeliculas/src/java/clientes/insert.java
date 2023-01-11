/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.simple.parser.ParseException;

/**
 *
 * @author prendamex
 */
public class insert {
         
    // PASO 1: Establecer la clase del driver y la URL de la base de datos
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String DB_URL2 = "jdbc:mysql://localhost/proyecto";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
          Connection conn;
          Connection conn2;
          Statement stmt;
          Statement stmt2;
            Class.forName(JDBC_DRIVER);

            //PASO 3: Abrir una conexion
            System.out.println("Conectandose a la base de datos...");
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              List<String> generos = ClienteOMDBApi.obtieneGeneros();
              Set<String> conjuntoGeneros = new HashSet<String>(generos);
           
              List<String> actores = ClienteOMDBApi.obtieneActores();
              Set<String> conjuntoActores = new HashSet<String>(actores);
              
              List<AbstractMap.SimpleEntry<String, String> >peli=ClienteOMDBApi.obtienePeliculas();
              Set<AbstractMap.SimpleEntry<String, String>> conpeli = new HashSet<AbstractMap.SimpleEntry<String, String>>(peli);
              PreparedStatement ps;
              String sql = "";
             // ps = conn.prepareStatement(sql);
              
              List<String >dire=ClienteOMDBApi.obtieneDir();
              Set<String>condir=new HashSet<String>(dire);
             
           // sql= "INSERT INTO proyecto.usuario (userp, contra, correo, nombre, edad, genero) VALUES (?,?,?,?,?,?);";
          //    sql = "insert into proyecto.genero(idgenero,nombre) values(?,?)";
             ps = conn.prepareStatement(sql);
            // ps.setInt(5, l);
             //ps.executeUpdate();
             
             int l=1;
             //GENEROS
         /*for(String a:conjuntoGeneros){
                 ps.setInt(1, l);
                 ++l;
                 ps.setString(2, a);
                 ps.executeUpdate();
             }
          
             //Actores
             l=1;
             sql="insert into proyecto.actores(idActores,nombre) values(?,?)";
             ps = conn.prepareStatement(sql);
             for(String a:conjuntoActores){
                  ps.setInt(1, l);
                  ++l;
                  ps.setString(2, a);
                  ps.executeUpdate();
            } 
         
             //Directores
              sql="insert into proyecto.director(iddirector,nombre) values(?,?)";
              ps = conn.prepareStatement(sql);
              l=1;
            for(String a:condir){
                  ps.setInt(1, l);
                  ++l;
                  ps.setString(2, a);
                  ps.executeUpdate();
            }
            
             //Pelicula
           
            sql="insert into proyecto.peliculas(idPeliculas,nombre) values(?,?)";
            ps = conn.prepareStatement(sql); 
            for(AbstractMap.SimpleEntry<String, String>a:conpeli){
              ps.setString(1,a.getKey());
              ps.setString(2, a.getValue());
              ps.executeUpdate();
             }*/
           conn.close();
       
    }
    
}
