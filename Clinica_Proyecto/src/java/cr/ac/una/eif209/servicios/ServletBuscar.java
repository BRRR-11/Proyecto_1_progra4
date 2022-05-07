/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.una.eif209.servicios;

import cr.ac.una.eif209.ejemplo2.modelo.Paciente;
import java.io.IOException;
import static java.lang.System.out;
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
 * @author ariqq
 */
@WebServlet(name = "ServletBuscar", urlPatterns = {"/ServletBuscar"})
public class ServletBuscar extends HttpServlet {

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
            String insertStr = "select * from paciente c where cedula=?";
            try (Connection cnx = db.getConnection();
                    PreparedStatement myInsert = cnx.prepareStatement(insertStr)) {

                myInsert.setString(1, request.getParameter("buscaCedula"));
                ResultSet rs = myInsert.executeQuery();
                if (rs.next()) {
                    Paciente c = from(rs, "c");
                    out.printf(c.toString());
                    request.setAttribute("objController", c);
                    
                } else {
                    out.printf("Cliente no Existe");
                }
                

            } catch (SQLException ex) {
                Logger.getLogger(ServletBuscar.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher a = request.getRequestDispatcher("Prueba.jsp");
            a.forward(request, response);

        } catch (NamingException ex) {
            Logger.getLogger(ServletBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Paciente from(ResultSet rs, String alias){
        try {
            Paciente c= new Paciente();
            c.setCedula(rs.getString(alias+".cedula"));
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
