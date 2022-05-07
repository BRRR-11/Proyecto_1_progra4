/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.una.eif209.servicios;

import cr.ac.una.eif209.ejemplo2.modelo.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "ServletLoginA", urlPatterns = {"/ServletLoginA"})
public class ServletLoginA extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      try {
            final String ruta_propiedades
                    = "/cr/ac/una/eif209/ejemplo2/db.properties";

            Properties p = new Properties();
            p.loadFromXML(getClass().getResourceAsStream(ruta_propiedades));

            InitialContext ctx = new InitialContext();
            DataSource db = (DataSource) ctx.lookup(p.getProperty("JNDI_name"));
            String insertStr = "select * from administrador c where cedula=? and clave=?";
            try (Connection cnx = db.getConnection();
                    PreparedStatement myInsert = cnx.prepareStatement(insertStr)) {

                myInsert.setString(1, request.getParameter("cedula"));
                myInsert.setString(2, request.getParameter("clave")); 
                ResultSet rs = myInsert.executeQuery();
                if (rs.next()) {
                        RequestDispatcher a = request.getRequestDispatcher("Administrador.jsp");
                        a.forward(request, response);
                    
                } else {
                    RequestDispatcher a = request.getRequestDispatcher("index.jsp");
                    a.forward(request, response);
                    //out.printf("Administrador no Existe");
                }
                

            } catch (SQLException ex) {
                Logger.getLogger(ServletBuscar.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } catch (NamingException ex) {
            Logger.getLogger(ServletBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Administrador from(ResultSet rs, String alias){
        try {
            Administrador c= new Administrador();
            c.setNombre(rs.getString(alias+".nombre"));
            c.setApellido(rs.getString(alias+".apellido"));
            c.setClave(rs.getString(alias+".clave"));
            return c;
        } catch (SQLException ex) {
            return null;
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
