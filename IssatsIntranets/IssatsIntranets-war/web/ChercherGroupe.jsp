<%-- 
    Document   : ChercherGroupe
    Created on : Oct 18, 2016, 6:11:48 PM
    Author     : dmidma
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Groupe</title>
    </head>
    <body>
        <h1>Hello Groupe</h1>
        
        
        <table style="border: 1px solid black;">
            <tr>
                <th>
                <td>Nom</td>
                <td>Prenom</td>
                <td>CIN</td>
                <td>Login</td>
                </th>
            </tr>
            
            <% HashMap<String, List<String>> map = (HashMap<String, List<String>>) session.getAttribute("map"); %>
            
            <%
             
            // get number of elements
            int nbrelements = map.get("name").size();
            
            
            
            for (int i = 0; i < nbrelements; i++) {
                out.println("<tr>");
                
                out.println("<td>");
                out.println(map.get("name").get(i));
                out.println("</td>");
                 
                out.println("<td>");
                out.println(map.get("lastName").get(i));
                out.println("</td>");
                
                out.println("<td>");
                out.println(map.get("CIN").get(i));
                out.println("</td>");
                
                out.println("<td>");
                out.println(map.get("Login").get(i));
                out.println("</td>");
             
                out.println("</tr>");
            }
                
             
             
                
            %>
            
        </table>
    </body>
</html>
