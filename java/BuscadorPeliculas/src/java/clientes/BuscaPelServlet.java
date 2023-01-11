/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package clientes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;


public class BuscaPelServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException 
    {
        String tema = request.getParameter("genero");
        System.out.println(tema);
        
        List<String> generos = ClienteOMDBApi.obtieneGeneros();
        Set<String> conjuntoGeneros = new HashSet<String>(generos);
        
        List<String> actores = ClienteOMDBApi.obtieneActores();
        Set<String> conjuntoActores = new HashSet<String>(actores);
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter())         {
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Generos, Actores</title>");    
            out.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"text-align:center\">Generos</h1>");
            out.println("<div>");
            out.println("<p>Generos</p><select name=\"generos\" id=\"generos\">");
            for(String cadaGen :conjuntoGeneros)   
            {
                out.println("<option value=\"" + cadaGen + "\">" + cadaGen + "</option>");
            }
            out.println("</select>");
            out.println("</div>");
             out.println("<div>");
            out.println("<p>Actores</p><select name=\"actores\" id=\"actores\">");
            for(String cadaAct :conjuntoActores)   
            {
                out.println("<option value=\"" + cadaAct + "\">" + cadaAct + "</option>");
            }
            out.println("</select>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscaPelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscaPelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
