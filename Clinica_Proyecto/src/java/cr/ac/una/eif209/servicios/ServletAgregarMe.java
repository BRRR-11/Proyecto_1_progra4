/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.una.eif209.servicios;

import cr.ac.una.eif209.ejemplo2.modelo.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet(name = "ServletAgregarMe", urlPatterns = {"/ServletAgregarMe"})
public class ServletAgregarMe extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            String insertStr = "insert into medico (cedula,nombre,apellido,clave,telefono,direccion,idEspecialidad,frecuenciaCita)"+" VALUES(?,?,?,?,?,?,?,?);";
            try (Connection cnx = db.getConnection();
                    PreparedStatement myInsert = cnx.prepareStatement(insertStr)) {

                Medico me = new Medico();

                myInsert.setString(1, request.getParameter("cedula"));
                myInsert.setString(2, request.getParameter("nombre"));
                myInsert.setString(3, request.getParameter("apellido"));
                myInsert.setString(4, request.getParameter("clave"));
                myInsert.setString(5, request.getParameter("telefono"));
                myInsert.setString(6, request.getParameter("direccion"));
                myInsert.setString(7, request.getParameter("idEspecialidad"));
                myInsert.setString(8, request.getParameter("frecuenciaCita"));
                int r = myInsert.executeUpdate();
            if (r == 1) {
                out.printf("Se agregó");
            } else {
                out.printf("No se pudo insertar");
            }

            }
            RequestDispatcher a= request.getRequestDispatcher("Pagina2.jsp");
            a.forward(request, response);
          

        } catch (IOException | NullPointerException | SQLException ex) {
            out.println(String.format("\tExcepción: '%s'%n", ex.getMessage()));
        } catch (NamingException ex) {
            Logger.getLogger(ServletAgregar.class.getName()).log(Level.SEVERE, null, ex);
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
