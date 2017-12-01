/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Cours;
import entities.CoursFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmidma
 */
@WebServlet(name="ServeletJPA", urlPatterns = {"/cours/add"})
public class ServletJPA extends HttpServlet {
@EJB
private CoursFacade fac;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("Code"));
        String nom = req.getParameter("Nom");
        String description = req.getParameter("Description");
        String url = req.getParameter("Url");
        String theme = req.getParameter("Theme");
        
        try (PrintWriter out = resp.getWriter()) {
            
            out.println("Hello world");
            
            try {
               Cours c = new Cours();
               c.setCode(id);
               c.setNom(nom);
               c.setDescription(description);
               c.setUrl(url);
               c.setTheme(theme);
               fac.create(c);
               out.println("Ajout avec succés");
            }
            catch (Exception ex) {
                out.println("Erreur : " + ex.toString());
            }
            
            out.println("Done");
           
        }
    }

}
