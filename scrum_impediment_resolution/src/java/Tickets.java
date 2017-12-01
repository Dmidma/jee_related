/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.MemberTicket;
import database.entityclasses.MemberTicketFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Tickets"})
public class Tickets extends HttpServlet {
    
    @EJB
    private MemberTicketFacadeLocal memberTicketFacade;
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
            
            // check if a user is connected or redirect to /ConnectMe
            
            HttpSession session = request.getSession(true);
            String admin = (String) session.getAttribute("admin");
            
            
            if (!"4".equals(admin)) {
               response.setStatus(response.SC_MOVED_TEMPORARILY);
               response.setHeader("Location", "/scrum_impediment_resolution/ConnectMe");
               return;
            }
            
            
            // get all tickets and filter only those related to this user
            List<MemberTicket> l = memberTicketFacade.findAll();
                    
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Current Tickets</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"    <style type=\"text/css\">\n" +
"        html, body, #wrapper{\n" +
"            height: 100%;\n" +
"        }\n" +
"    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"wrapper\">\n" +
"        <header>\n" + "<nav class=\"navbar navbar-default\">\n" +
"                <div class=\"container-fluid\">\n" +
"                    <div class=\"navbar-header\">\n" +
"                      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#MENU\" aria-expanded=\"false\">\n" +
"                        <span class=\"sr-only\">Toggle navigation</span>\n" +
"                        <span class=\"icon-bar\"></span>\n" +
"                        <span class=\"icon-bar\"></span>\n" +
"                        <span class=\"icon-bar\"></span>\n" +
"                      </button>\n" +
"                        <span class=\"navbar-brand\"><span >Scrum Impediment Resolution</span></span>\n" +
"                    </div>\n" +
"\n" +
"                    <div class=\"collapse navbar-collapse\" id=\"MENU\">\n" +
"                      <ul class=\"nav navbar-nav navbar-right\">\n" +
"                        <li><a href=\"/scrum_impediment_resolution/connected/ConnectMe?log=out\">Log Out</a></li>\n" +
"                      </ul>\n" +
"                    <div class=\"cleafix\"></div>\n" +
"                </div>\n" +
"            </nav>" + "</header>\n" +
"        <div class=\"container\">\n" +
"\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-8 col-md-offset-2\">\n" +
"                    <div class=\"panel panel-primary\">\n" +
"                        <div class=\"panel-heading\">\n" +
"                            <h3>Current tickets</h3>\n" +
"                        </div>\n" +
"                        <div class=\"panel-body\">\n" +
"                            <div class=\"list-group\">");
            
            if (l.isEmpty()) {
                out.println("<b>No Tickets</b>");
            }
            else {
                l.forEach(i -> out.println("<div class=\"list-group-item\"><a class=\"list-group-item\" style=\"display: inline-block;\n" +
"    width: 90%;\n" +
"}\" href=\"/scrum_impediment_resolution/SpecificTicket?id=" + i.getId() + "\">" + i.getIdImpediment().getId() + ", " + i.getIdImpediment().getSubject()+ "<a href=\"/scrum_impediment_resolution/Tickets?id=" + i.getId() + "\" style=\"    display: inline-block;\n" +
"    border: 1px solid #ddd;\n" +
"    border-radius: 5px;\n" + 
"    padding: 10px;\n" +
"    margin-left: 10px;\">X</a></a></div>"));
            }
            out.println("</div>\n" +
"                        </div>\n" +
"                        <div class=\"panel-footer\">\n" +
"                            <p><small><center>Scrum Ticketing</center></small></p>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"\n" +
"    </div>");
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
        
        // get id 
        if (request.getParameter("id") != null) {
            
        
        int ticketId = Integer.parseInt((String) request.getParameter("id"));
        
        
        MemberTicket t = memberTicketFacade.find(ticketId);
        
        if (t != null) {
            memberTicketFacade.remove(t);
        }
        
        }
        
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
