<%-- 
    Document   : EspaceMember
    Created on : Oct 18, 2016, 4:07:49 PM
    Author     : dmidma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Etudiant" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etudiant</title>
    </head>
    <body>
        <h1>Espace Etudiant</h1>
         
        
        <% Etudiant et = (Etudiant) session.getAttribute("Etudiant"); %>
        
        
        <% out.println("<h3>" + et.login + "</h3>"); %>
        <% out.println("<p>" + et.name + "</p>"); %>
        <% out.println("<p>" + et.lastName + "</p>"); %>
        <% out.println("<p>" + et.CIN + "</p>"); %>
        
    </body>
</html>
