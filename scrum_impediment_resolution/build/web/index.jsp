<%-- 
    Document   : index
    Created on : Jan 30, 2017, 3:44:51 AM
    Author     : dmidma
--%>

<%@page import="java.util.List"%>
<%@page import="database.entityclasses.Member1Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="database.entityclasses.Member1FacadeLocal"%>
<%@page import="database.Member1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connect Me</title>
    </head>
    <body>
        <h1>Weclome To Scrum Platfrom</h1>
        <jsp:useBean id="useme" class="database.entityclasses.Member1FacadeLocal">
            
            <% 
                
                List<Member1> l = useme.findAll();
                    for (Member1 i : l) {
                out.println(i.getName());
                out.println("<br/>");
            }
            %>
        </jsp:useBean>
    </body>
</html>

