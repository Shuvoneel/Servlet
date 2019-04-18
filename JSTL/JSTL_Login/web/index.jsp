
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Index Page</title>
    </head>
    <body>
        <h1>Hello <c:out value="${fn:toUpperCase(sessionScope['loginUser'])}" /></h1>
        <c:if test="${empty sessionScope['loginUser']}">
            <c:redirect url="login.jsp" />
        </c:if>

        <a href="login.jsp">Logout </a>
    </body>
</html>
<!--
create database jstlshuvo;
CREATE TABLE users(
  id int(10) auto_increment primary key,
  username varchar(45) NOT NULL,
  password varchar(45) NOT NULL
);
 
INSERT INTO users (username,password) VALUES ("admin","123");
-->