/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prendamex
 */
public class operBD {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String DB_URL2 = "jdbc:mysql://localhost/proyecto";
    static final String USER = "root";
    static final String PASS = "1234";
    static Connection conn;
    static Statement stmt;

    public operBD() {
    }
    
    public static String responNue(String user,String nombre,String gene,String con,String correo,int edad) throws ClassNotFoundException, SQLException{
            Class.forName(JDBC_DRIVER);
            
              String res="a";
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              PreparedStatement ps;
              String sql = "SELECT idUsuario from proyecto.usuario where userp=?";
              ps=conn.prepareStatement(sql);
              ps.setString(1, user);
              ResultSet rs =ps.executeQuery(); 
              int i=0;
              while(rs.next()){
                  ++i;
                  res="false";
              }
              if(i==0){
                     sql="INSERT INTO proyecto.usuario ( userp, contra, correo, nombre, edad, genero) VALUES (?,?,?,?,?,?);";
                     ps = conn.prepareStatement(sql);
                     ps.setString(1, user);
                     ps.setString(2, con);
                     ps.setString(3,correo);
                     ps.setString(4,nombre );
                     ps.setInt(5, edad);
                     ps.setString(6, gene);
                     ps.executeUpdate();
               res="true";
              }
        conn.close();
        return res;
    }    
    public static ArrayList<Map.Entry<String,String>> cargaListaUsuarios() throws ClassNotFoundException
    {
       ArrayList<Map.Entry<String,String>>lista =new ArrayList(); 
         try 
        {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) 
            {
                System.out.println("UtilBD ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM proyecto.usuario;";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) 
                {
                lista.add(new AbstractMap.SimpleEntry(rs.getString("userp"),rs.getString("contra")));
                    
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()+"de aqiii");
            Logger.getLogger(operBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
