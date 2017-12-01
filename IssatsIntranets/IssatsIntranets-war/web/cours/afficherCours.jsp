<%-- 
    Document   : afficherCours.jsp
    Created on : Nov 1, 2016, 4:39:38 PM
    Author     : dmidma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    <style>
        td {
            border: 1px solid black;
        }
        table {
            border: 1px double aqua;
        }
    </style>
    
    <sql:setDataSource
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/duck"
        password="password"
        user="testuser"></sql:setDataSource>
     <sql:query var="result">SELECT * FROM cours;</sql:query>
     <table>
         <th><tr><td>code</td><td>nom</td><td>description</td><td>url</td><td>theme</td></tr></th>
     
        
         <c:forEach var="row" items="${result.rows}">
             <tr>
             <td><c:out value="${row.code}"/></td>
             <td><c:out value="${row.nom}"/></td>
            <td><c:out value="${row.description}"/></td>
            <td><c:out value="${row.url}"/></td>
            <td><c:out value="${row.theme}"/></td>
            <tr/>
        </c:forEach>
            </table>
    
</html>
