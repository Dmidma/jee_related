/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.Member1;
import database.entityclasses.Member1FacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dmidma
 */
@WebServlet(urlPatterns = {"/ConnectMe"}, initParams = {
    @WebInitParam(name = "foo", value = "bar")})
public class ConnectMe extends HttpServlet {

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
            if (session.getAttribute("connected_user") != null) {
               response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
               response.setHeader("Location", "/scrum_impediment_resolution/Profile");
               return;
            } else {
                // check admin
                String admin = (String) session.getAttribute("admin");
                    if ("4".equals(admin)) {
                        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                        response.setHeader("Location", "/scrum_impediment_resolution/Tickets");
                        return;
                    }
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConnectMe To platform</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"    <style type=\"text/css\">\n" +
"        html, body, #wrapper{\n" +
"            height: 100%;\n" +
"        }\n" +
"    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"wrapper\">\n" +
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
"                <div class=\"col-md-6 col-md-offset-3\">\n" +
"                    <div class=\"panel panel-primary\">\n" +
"                        <div class=\"panel-heading\">");
            out.println("<h3>Connect to your tickets</h3>");
            out.println("</div>\n" +
"                        <div class=\"panel-body\">");
            
            List<Member1> users = member1Facade.findAll();
            
            
            
            // main form
            out.println("<form class=\"form\" action=\"/scrum_impediment_resolution/ConnectMe\" method=\"POST\">");
            // User selection
            out.println("<div class=\"form-group\">\n" +
"                                <label for=\"userInput\">User</label>");
            out.println("<select class=\"form-control\" id=\"userInput\" name=\"user\">");
            for (Member1 i : users) {
                out.println("<option value=\"" + i.getId() + "\">" + i.getName() + " " + i.getLastName() + "</option>");
            }
            out.println("</select></div>");
            
            // team leader validation
            out.println("<div class=\"form-group\">\n" +
"                                <label for=\"team-bool\">Team Leader</label>");
            out.println("<select class=\"form-control\" id=\"team-bool\" name=\"leader\">");
            out.println("<option selected=\"selected\" value=\"" + "None" + "\">None</option>");
            out.println("<option value=\"" + "yes" + "\">Yes</option>");
            out.println("<option value=\"" + "no" + "\">No</option>");
            out.println("</select>");
            
            out.println("</div>\n" +
"                              <button type=\"submit\" class=\"btn btn-default\">Connect</button>\n" +
"                            </form>\n" +
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
         
            
           
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    private void logIn(HttpSession session, String user, String leader) {
        session.setAttribute("connected_user", user);
        session.setAttribute("leader", leader);
    }
    
    private void logOut(HttpSession session) {
        session.removeAttribute("connected_user");
        session.removeAttribute("leader");
        session.removeAttribute("admin");
    }
    
    /**
     * this will be responsible of the redirection of the user
     * If there is a simple user, it will redirect him to his profile
     * If it is an admin, it will redirect him to the Admin platform
     */
    private void redirect(HttpSession session) {
        String user_id = (String) session.getAttribute("connected_user");
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
        
        String log = request.getParameter("log");
        
        if ("out".equals(log))
            logOut(request.getSession(true));
        
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
           
        
        // get parameter of the post command
        String user = request.getParameter("user");
        String leader = request.getParameter("leader");
        
          
        // create http session
        HttpSession session = request.getSession(true);
        
        
        // we deal with Admin with a different manner
        // instead of using a specific admin, I am going to add a row into the member table 
        // in this case the id of adming is 4
        if ("4".equals(user)) {
            session.setAttribute("admin", "4");
            // request.getServletContext().getRequestDispatcher("/Tickets").forward(request, response);
            processRequest(request, response);
        }
        else {
            // set the connected user
            session.setAttribute("connected_user", user);
            session.setAttribute("leader", leader);



            request.getServletContext().getRequestDispatcher("/Profile").forward(request, response);
            //request.getRequestDispatcher("/ListMembers").forward(request, response);
        }
 
        
  
        // processRequest(request, response);
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
