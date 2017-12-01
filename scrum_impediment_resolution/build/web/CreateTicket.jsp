<%-- 
    Document   : CreateTicket
    Created on : Jan 30, 2017, 4:44:57 AM
    Author     : dmidma
--%>
<%--Check if a user is connected, else redirect him to /ConnectMe --%>
      <% 
           String user_id = (String) session.getAttribute("connected_user");
          
          
           if (user_id == null) {
               response.setStatus(response.SC_MOVED_TEMPORARILY);
               response.setHeader("Location", "/scrum_impediment_resolution/ConnectMe");
               return;
           }
               
           int id_user = Integer.parseInt(user_id);
         %>    



<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket Creation</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        html, body, #wrapper{
            height: 100%;
        }
    </style>
    </head>
     
        
          <div id="wrapper">
        <header>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#MENU" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>
                        <span class="navbar-brand"><span >Scrum Impediment Resolution</span></span>
                    </div>

                    <div class="collapse navbar-collapse" id="MENU">
                      <ul class="nav navbar-nav navbar-right">
                        <li><a href="/scrum_impediment_resolution/Profile">Profile</a></li>
                      </ul>
                    <div class="cleafix"></div>
                </div>
            </nav>
        </header>
        <div class="container">

            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
         <h3>Create Ticket</h3>
                        </div>
                        <div class="panel-body">
         <form class="form" action="/scrum_impediment_resolution/connected/CreateTicket.jsp" method="post">
             
             
             <div class="form-group">
                                <label for="subject">Subject</label>
                                <input type="text" name="subject" class="form-control" id="subject">

                              </div>
                              <div class="form-group">
                                <label for="description">Description</label>
                                <textarea name="description" class="form-control" id="description"></textarea>

                              </div>
                              <div class="form-group">
                                <label for="prio">Priority</label>
                                <select name="priority" class="form-control" id="prio">
                                    <option>minor</option>
                                    <option>Moderate</option>
                                    <option>critical</option>
                                </select>
                              </div>
                              <button type="submit" class="btn btn-default">Create</button>
      
         </form>
                            </div>
                        <div class="panel-footer">
                            <p><small><center>Scrum Ticketing</center></small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <footer>
            <p>XYZ PEOPLE</p>
    </footer>
         
         <jsp:useBean id="imp" class="database.Impediment">
             <jsp:setProperty name="imp" property="subject" param="subject" />
             <jsp:setProperty name="imp" property="description" param="description" />
             <jsp:setProperty name="imp" property="priority" param="priority" />
            
            <c:if test="${imp.subject != null}">
             
                
                 <sql:setDataSource  
                 var="connect_table"
                 driver="com.mysql.jdbc.Driver" 
                 url="jdbc:mysql://localhost/impediment_resolution" 
                 user="testuser" 
                 password="password"
                 />
                <sql:transaction dataSource="${connect_table}">
                    <sql:update var="insertion">
                    INSERT INTO impediment (subject, description, priority) VALUES (
                    "<jsp:getProperty name="imp" property="subject" />",
                    "<jsp:getProperty name="imp" property="description" />",
                    "<jsp:getProperty name="imp" property="priority" />");
                    </sql:update>
                    <sql:query var="last_id">
                        SELECT LAST_INSERT_ID() AS id;
                    </sql:query>
                    <sql:update var="ticket">
                        INSERT INTO member_ticket (id_impediment, id_member) VALUES (LAST_INSERT_ID(), <%=id_user%>);
                    </sql:update>
                </sql:transaction>
                        
                        
                        <c:if test="${ticket > 0}">
                            <c:out value="<h3>Something went wrong, please Repeat!</h3>" />    
                        </c:if> 
            </c:if>
         </jsp:useBean>
         
</html>
