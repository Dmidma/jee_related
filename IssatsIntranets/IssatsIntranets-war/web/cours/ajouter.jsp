<%-- 
    Document   : ajouter
    Created on : Nov 1, 2016, 3:58:58 PM
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
</html>
<jsp:useBean id="cours" class="model.Cours">
    <jsp:setProperty name="cours" property="code" param="Code"/>
    <jsp:setProperty name="cours" property="nom" param="Nom"/>
    <jsp:setProperty name="cours" property="description" param="Description"/>
    <jsp:setProperty name="cours" property="url" param="Url"/>
    <jsp:setProperty name="cours" property="theme" param="Theme"/>
   
    
    <sql:setDataSource
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/duck"
        password="password"
        user="testuser"></sql:setDataSource>
    <sql:update var="result">
        INSERT INTO cours (code, nom, description, url, theme) VALUES (
        "<jsp:getProperty name="cours" property="code" />",
        "<jsp:getProperty name="cours" property="nom" />",
        "<jsp:getProperty name="cours" property="description" />",
        "<jsp:getProperty name="cours" property="url" />",
        "<jsp:getProperty name="cours" property="theme" />");
    </sql:update>
       
        <c:if test="${result > 0}" >
            <c:redirect url="/cours/afficherCours.jsp"/>
        </c:if>

</jsp:useBean>

<h5>Pas d'insertion</h5>