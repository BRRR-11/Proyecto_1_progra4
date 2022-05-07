/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.una.eif209.servicios;

import cr.ac.una.eif209.ejemplo2.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServletListar", urlPatterns = {"/ServletListar"})
public class ServletListar extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//////////////////////////////////////////////////////////////////////////////////////////
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
//            Paciente obj=new Paciente();
//            obj.setCedula(request.getParameter("id"));
//            obj.setNombre(request.getParameter("nombre"));
//            obj.setApellido(request.getParameter("apellido1"));
//            obj.setClave(request.getParameter("apellido2"));
//            //obj.NombreCompleto();

                Paciente obj = new Paciente();   
                request.setAttribute("servListar", obj);
////////////////////////////////////////////////////////////////////////////////////////////
try {
            final String ruta_propiedades
                    = "/cr/ac/una/eif209/ejemplo2/db.properties";
            
             final String seleccion
                   = "SELECT * FROM paciente ORDER BY cedula;";

            Properties p = new Properties();
            p.loadFromXML(getClass().getResourceAsStream(ruta_propiedades));

            InitialContext ctx = new InitialContext();
            DataSource db = (DataSource) ctx.lookup(p.getProperty("JNDI_name"));
           try (Connection cnx = db.getConnection();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(seleccion)) {
                while (rs.next()) {
                    Paciente paciente = new Paciente(
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("clave")
                );
                    out.println(String.format("\t%s<br />%n", paciente));
                }



                }
            RequestDispatcher a= request.getRequestDispatcher("Prueba.jsp");
            a.forward(request, response);
          

        } catch (IOException | NullPointerException | SQLException ex) {
            out.println(String.format("\tExcepción: '%s'%n", ex.getMessage()));
        } catch (NamingException ex) {
            Logger.getLogger(ServletAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
///////////////////////////////////////////////////////////////////////////////////////////
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            RequestDispatcher a= request.getRequestDispatcher("Prueba.jsp");
            a.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
