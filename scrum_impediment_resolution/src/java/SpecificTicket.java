/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.Comment;
import database.entityclasses.MemberTicketFacadeLocal;
import database.MemberTicket;
import database.TicketComment;
import database.entityclasses.CommentFacadeLocal;
import database.entityclasses.Member1FacadeLocal;
import database.entityclasses.TicketCommentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
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
@WebServlet(urlPatterns = {"/SpecificTicket"})
public class SpecificTicket extends HttpServlet {

    @EJB
    private CommentFacadeLocal commentFacade;

    @EJB
    private TicketCommentFacadeLocal ticketCommentFacade;

    @EJB
    private MemberTicketFacadeLocal memberTicketFacade;

    @EJB
    private Member1FacadeLocal member1Facade;

    
    

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
        
        // get ticket id
        String ticketId = request.getParameter("id");
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
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
"                        <li><a href=\"/scrum_impediment_resolution/Profile\">Profile</a></li>\n" +
"                      </ul>\n" +
"                    <div class=\"cleafix\"></div>\n" +
"                </div>\n" +
"            </nav>" +
"        </header>\n" +
"        <div class=\"container\">\n" +
"\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-8 col-md-offset-2\">\n" +
"                    <div class=\"panel panel-primary\">\n" +
"                        <div class=\"panel-heading\">");
            
            if (ticketId == null) {
                out.println("<h3>No Ticket</h3><div class=\"clearprefix\"></div>\n" +
"                        </div>");
            }
            else {
                int tI;
                try {
                    tI = Integer.parseInt(ticketId);
                } catch (NumberFormatException ex) {
                    
                    out.println("<h3>This is not a valid Ticket ID</h3><div class=\"clearprefix\"></div>\n" +
"                        </div>");
                
                    return;
                }
                
                MemberTicket t = memberTicketFacade.find(tI);
                
                out.println("<h3>#" + t.getId() + " " + t.getIdImpediment().getSubject() + "<strong class=\"pull-right\">" +
                        ((t.getResolvedDate() == null)? "Open": "Resolved")
                        + 
                                ": (" + t.getIdImpediment().getPriority() + ")</strong></h3>\n" +
"\n" +
"                            <div class=\"clearprefix\"></div>\n" +
"                        </div>\n" +
"                        <div class=\"panel-body\">\n" +
"                            <div class=\"well\">\n" +
"                                <p>" + t.getIdImpediment().getDescription() + "</p>\n" +
                        "<p class=\"pull-right\">Posted by:" + t.getIdMember().getName() + " " + t.getIdMember().getLastName() + "<span>On:" + t.getCreationDate() + "</span></p>\n" +
"                                <div class=\"clearprefix\"></div>" +
"                            </div>\n");
                
                ticketCommentFacade.findAll()
                        .stream()
                        .filter(i -> i.getIdMemberTicket().getId() == Integer.parseInt(request.getParameter("id")))
                        
                        .forEach(i -> out.println("<div class=\"well\">\n" +
                                "<p>" + i.getIdComment().getComment() + "</p>\n" + 
                                "<p class=\"pull-right\">Posted by:" + 
                                i.getIdComment().getIdMember().getName() + 
                                " " + i.getIdComment().getIdMember().getLastName() + 
                                "<span> On:" + 
                                i.getIdComment().getCommentDate() + 
                                "</span></p>\n" +
                                "<div class=\"clearprefix\"></div></div>"));
                
                
                
            out.println("<form class=\"form\" action=\"/scrum_impediment_resolution/connected/SpecificTicket\" method=\"post\">\n" +
"                                <div class=\"form-group\">\n" +
"                                    <label for=\"reply\" class=\"sr-only\">Reply</label>\n" +
"<input name=\"id\" value=\"" + t.getId() + "\" style=\"display:none;\" /><textarea class=\"form-control\" name=\"reply\" placeholder=\"Resolution Reply\"></textarea>\n" +
"                                </div>\n"); 
                
                // only for admin
                HttpSession session = request.getSession(true);
                String admin = (String) session.getAttribute("admin");


                if ("4".equals(admin)) {
                out.println("<div class=\"form-group\">\n" + 
                       "<label for=\"status\" class=\"sr-only\">Status</label>\n" + 
                       "<select name=\"status\" class=\"form-control\" id=\"status\">\n" + 
                       "<option value=\"open\" selected=\"selected\">Open</option>\n" + 
                       "<option value=\"resolved\">Resolved</option>\n" + 
                       "</select>\n" + 
                       "</div>");
                }
                
                
                
                
                
                out.println("<button type=\"submit\" class=\"btn btn-default\">Reply</button>\n" +
"                            </form>\n" +
"                        </div>");
                
            }
            
            out.println("<div class=\"panel-footer\">\n" +
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
            
            out.println("</body>");
            out.println("</html>");
            
        }
        
        
    }

    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        
        
        HttpSession session = request.getSession(true);
        // a user is connected
        String connected_id = null;
        if (session.getAttribute("connected_user") != null && session.getAttribute("admin") == null) {
            connected_id = (String) session.getAttribute("connected_user");
        } else if (session.getAttribute("connected_user") == null && session.getAttribute("admin") != null) {
           connected_id = (String) session.getAttribute("admin");
        }
        
        // yeah that's right, someone must be connected
        if (connected_id != null) {
            // get two 
            String reply = request.getParameter("reply");
            String status = request.getParameter("status");
            
            if (reply != null) {
                
                TicketComment tc = new TicketComment();
                
                Comment c = new Comment();
                c.setIdMember(member1Facade.find(Integer.parseInt(connected_id)));
                c.setComment(reply);
                c.setCommentDate(new Date());
                
                commentFacade.create(c);
                
                // ticket id
                MemberTicket t = memberTicketFacade.find(Integer.parseInt(request.getParameter("id")));
                
                
                // check if the admin has changed the status
                if (Integer.parseInt(connected_id) == 4) {
                    if ("resolved".equals(status)) {
                        
                        t.setResolvedDate(new Date());
                        
                    } else {
                        t.setResolvedDate(null);
                    }
                    
                    memberTicketFacade.edit(t);
                }
                
                
                tc.setIdComment(c);
                tc.setIdMemberTicket(t);
                
                
                ticketCommentFacade.create(tc);
                
            }
            
        }
        
        
        doGet(request, response);
        
        
        
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
