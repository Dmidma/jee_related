/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CoursFacadeLocal;
import session.local.Cours;

/**
 *
 * @author dmidma
 */
@WebServlet(name="Add", urlPatterns = {"/cours/add"})
public class Add extends HttpServlet {

    @EJB
    private CoursFacadeLocal coursFacade;

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
        
        
        int id = Integer.parseInt(request.getParameter("Code"));
        String nom = request.getParameter("Nom");
        String description = request.getParameter("Description");
        String url = request.getParameter("Url");
        String theme = request.getParameter("Theme");
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("Hello world");
            
            try {
               Cours c = new Cours();
               c.setCode(id);
               c.setNom(nom);
               c.setDescription(description);
               c.setUrl(url);
               c.setTheme(theme);
               coursFacade.create(c);
               out.println("Ajout avec succés");
            }
            catch (Exception ex) {
                out.println("Erreur : " + ex.toString());
            }
            
            out.println("Done");
           
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
