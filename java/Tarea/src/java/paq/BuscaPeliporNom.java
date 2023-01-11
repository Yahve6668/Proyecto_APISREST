/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package paq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author prendamex
 */
@WebServlet(name = "BuscaPeliporNom", urlPatterns = {"/BuscaPeliporNom"})
public class BuscaPeliporNom extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static int c=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        ArrayList<Pelicula> peliculas= new ArrayList<Pelicula>();
        if(c==0){
        String tema = request.getParameter("nomP");
        System.out.println(tema);
        peliculas = ClienteRestPeliculaNo.peliculasPorTema(tema);
       }
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if(c==0){
                         ++c;

            out.println("<html>\n" +
"	<head>\n" +
"		<meta charset=\"utf-8\">\n" +
"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"		<title></title>\n" +
"		<link rel=\"stylesheet\" href=\"table.css\">" +
"		<meta name=\"description\" content=\"\">\n" +
"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"		<link rel=\"stylesheet\" href=\"\">\n" +
"	</head>\n" +
"	<body>\n" +
"		<section>\n" +
"			<!--for demo wrap-->\n" +
"			<h1>Resultados</h1>\n" +
"			<div class=\"tbl-header\">\n" +
"\n" +
"			  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"				<thead>\n" +
"					\n" +
"					<tr>\n" +
"					<th>Título</th>\n" +
"					<th>Año</th>\n" +
"					<th>Poster</th>\n" +
"					<th>Informacion</th>\n" +
"				 </tr>\n" +
"				</thead>\n" +
"			  </table>\n" +
"\n" +
"			</div>\n" +
"			<div class=\"tbl-content\">\n" +
"			  <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"				<tbody>\n" +
"				");
            
            int j=0;
            for(Pelicula cadaPel :peliculas) 
            {
                out.println("		<tr style=\"outline: thin solid\">" +
"					<td style=\"text-align:center\"> "+ cadaPel.getTitulo() +"</td>" +
"					<td style=\"text-align:center\">"+ cadaPel.getAnio() + "</td>" +
"					<td><img src="+ cadaPel.getPoster() +"width=\"100\" height=\"150\"></td>\n" +
"					<td><form action=\"BuscaPeliporNom\">" +"<div class=\"pelicula-principal\">\n" +
"			<div class=\"contenedor\">"+
        
"					<button  name=\"button\" value="+cadaPel.getId()+" class=\"boton\"><i class=\"fas fa-info-circle\"></i> Ver informacion</button>" +
"					</form></td>\n" +
"					  \n" +"	</div>\n" +
"		</div>"+
        
"					</tr>\n" );
              
                ++j;
            }
            out.println("	</tbody>\n" +
"			  </table>\n" +
"			</div>\n" +
"		  </section>\n" +
"		  \n" +
"	</body>\n" +
"</html>");
         }else{
                   
         c=0;   
            String e=request.getParameter("button");
            
            Pelicula t=ClienteRestPeliculaNo.InfoPeli(e);
            out.println("<html lang=\"en\">\n" +
"<head>\n" +
"	<meta charset=\"UTF-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<link rel=\"stylesheet\" href=\"pre.css\">\n" +
"    <style> \n" +
"    .pelicula-principal {\n" +
"        font-size: 16px;\n" +
"        min-height: 40.62em;\n" +
"        color: #fff;\n" +
"        background: linear-gradient(rgba(0, 0, 0, .50) 0%, rgba(0,0,0,.50) 100%), url("+t.getPoster() +");"+
"        background-position: center center;\n" +
"        background-size: cover;\n" +
"        margin-bottom: 3.12em;\n" +
"        display: flex;\n" +
"        align-items: end;\n" +
"    }</style>\n" +
"	<link href=\"https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:wght@400;600&display=swap\" rel=\"stylesheet\"> \n" +
"	<title>Netflix</title>\n" +
"</head>\n" +
"<body>\n" +
"	<header>\n" +
"		<div class=\"contenedor\">\n" +
"			<h2 class=\"logotipo\">INFORMACION</h2>\n" +
"		</div>\n" +
"	</header>\n" +
"	<main>\n" +
"		<div class=\"pelicula-principal\">\n" +
"			<div class=\"contenedor\">\n" +
"				<h3 class=\"titulo\">"+t.getTitulo() +"</h3>\n" +
"				<p class=\"descripcion\">\n" +"Fecha de lanzamiento "+t.getFehcal()+"<br>"+
        "Duracion "+t.getDuracion()+ "<br>"+"Clasificacion "+t.getCategoria()+ "<br>"+ 
                "Dominaciones "+t.getDomina()+ "<br>"+"Director "+t.getDirector()+ "<br>"+
                        "Actores "+t.getActors()+ "<br>"+
                        "Sinopsis<br> "+t.getDes()+ "<br>"+        
"					 \n" +
"				</p>\n" +
"				<button role=\"button\" class=\"boton\"><i class=\"fas fa-play\"></i>Reproducir</button>\n" +
"			</div>\n" +
            "   <button role=\"button\" class=\"boton\" onclick=\"a();\">Regresar</button>\n" +
"		 " +
"		</div>\n" +
"	</main>\n" +
"	\n" +"<script>	function a() { window.location.href = \"http://localhost:8080/ProyectoC/principal.html\"; }</script>"+
"	<script src=\"https://kit.fontawesome.com/2c36e9b7b1.js\" crossorigin=\"anonymous\"></script>\n" +
"</body>\n" +
"</html>");
            
            
            
         /*   
            Pelicula t=ClienteRestPeliculaNo.InfoPeli(e);
            out.println("<h1>"+t.getTitulo()+"</h1>");
            out.print("<img src=\"" + t.getPoster() + "\"  width=\"100\" height=\"150\">");
            out.println("<p>"+t.toString()+"</p>");
            out.println("<button>Regresar</button>");
            out.println("</body>");
            out.println("</html>");
        */
                
          }
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
            Logger.getLogger(BuscaPeliporNom.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BuscaPeliporNom.class.getName()).log(Level.SEVERE, null, ex);
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
