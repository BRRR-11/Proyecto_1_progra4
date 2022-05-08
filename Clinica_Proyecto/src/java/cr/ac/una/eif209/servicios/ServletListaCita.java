/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cr.ac.una.eif209.servicios;


import cr.ac.una.eif209.ejemplo2.modelo.Cita;
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
 * @author ariqq
 */
@WebServlet(name = "ServletListaCita", urlPatterns = {"/ServletListaCita"})
public class ServletListaCita extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
             final String ruta_propiedades
                    = "/cr/ac/una/eif209/ejemplo2/db.properties";

            Properties p = new Properties();
            p.loadFromXML(getClass().getResourceAsStream(ruta_propiedades));

            InitialContext ctx = new InitialContext();
            DataSource db = (DataSource) ctx.lookup(p.getProperty("JNDI_name"));
            String insertStr = "select * from cita c where id_Medico=?";
            try (Connection cnx = db.getConnection();
                    PreparedStatement myInsert = cnx.prepareStatement(insertStr)) {

                myInsert.setString(1, request.getParameter("cedula"));
                ResultSet rs = myInsert.executeQuery();
                
                if (rs.next()) {
                    while(rs.next()){
                    Cita c = from(rs, "c");
                    out.printf(c.toString());
                    request.setAttribute("objController", c);
                    
                }
                    
                } else {
                    out.printf("Cliente no Existe");
                }
                RequestDispatcher a = request.getRequestDispatcher("InfoCitas.jsp");
                a.forward(request, response);
                

            } catch (SQLException ex) {
                Logger.getLogger(ServletBuscar.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } catch (NamingException ex) {
            Logger.getLogger(ServletBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Cita from(ResultSet rs, String alias){
        try {
            Cita c= new Cita();
            c.setId_Medico(rs.getString(alias+".id_Medico"));
            c.setId_Paciente(rs.getString(alias+".id_Paciente"));
            c.setHora(rs.getString(alias+".hora"));
            c.setEstado(rs.getString(alias+".estado"));
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
