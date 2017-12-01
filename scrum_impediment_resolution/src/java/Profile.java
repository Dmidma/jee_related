/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.entityclasses.Member1FacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dmidma
 */
@WebServlet(urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

    @EJB
    private Member1FacadeLocal member1Facade;

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
               
            HttpSession session = request.getSession(true);
            if (session.getAttribute("connected_user") == null) {
               response.setStatus(response.SC_MOVED_TEMPORARILY);
               response.setHeader("Location", "/scrum_impediment_resolution/ConnectMe");
               return;
            }
            
            // get user id
            int user_id = Integer.parseInt((String) session.getAttribute("connected_user"));
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Profile</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"    <style type=\"text/css\">\n" +
"        html, body, #wrapper{\n" +
"            height: 100%;\n" +
"        }\n" +
"    </style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("    <div id=\"wrapper\">\n" +
"        <header>\n" +
"            <nav class=\"navbar navbar-default\">\n" +
"                <div class=\"container-fluid\">\n" +
"                    <p class=\"navbar-brand\"><span >Scrum Impediment Resolution</span></p>\n" +
"                    <p><span class=\"pull-right navbar-brand\">J2EE</span></p>\n" +
"                    <div class=\"cleafix\"></div>\n" +
"                </div>\n" +
"            </nav>\n" +
"        </header>\n" +
"        <div class=\"container\">\n" +
"\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-4 col-md-offset-4\">\n" +
"                    <div class=\"panel panel-default\" style=\"text-align:center\">\n" +
"                        <div class=\"panel-heading\" >\n" +
"                            <h3>" + member1Facade.find(user_id).getName() + " " + member1Facade.find(user_id).getLastName() + "</h3>\n" +
"                            <p><strong>" + member1Facade.find(user_id).getJob() +"</strong></p>\n" +
"                            <p>" + member1Facade.find(user_id).getEmail() + "</p>\n" +
"\n" +
"                        </div>\n" +
"                        <div class=\"panel-body\">\n" +
"                            <ul class=\"nav\">\n" +
"                                <li>\n");
out.println("<a href=\"/scrum_impediment_resolution/connected/CreateTicket.jsp\">\n" +
"                                    <i class=\"glyphicon glyphicon-pencil\"></i>\n" +
"                                    Create Ticket </a>\n" +
"                                </li>\n" +
"                                <li>\n"); 
 
            out.println("<a href=\"/scrum_impediment_resolution/CurrentTickets\" >\n" +
"                                    <i class=\"glyphicon glyphicon-th-list\"></i>\n" +
"                                    Current Tickets </a>\n" +
"                                </li>\n" +
"                                <li>\n");
out.println("<a href=\"/scrum_impediment_resolution/connected/ConnectMe?log=out\">\n" +
"                                    <i class=\"glyphicon glyphicon-off\"></i>\n" +
"                                    Logout </a>\n" +
"                                </li>\n" +
"                            </ul>\n" +
"\n" +
"                        </div>\n" +
"                        <div class=\"panel-footer\">\n" +
"                            <p><small><center>Scrum Ticketing</center></small></p>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"\n" +
"    </div>\n" +
"    <footer>\n" +
"            <p>XYZ PEOPLE</p>\n" +
"    </footer>");
            
            
            
            out.println("<a href=\"\">Create Ticket</a>");
            
            
            
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
