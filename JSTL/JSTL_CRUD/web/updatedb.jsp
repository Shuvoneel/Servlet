
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*, java.sql.*, java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updatedb Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/jstlshuvo"
                           user="root" password="1234"></sql:setDataSource>
        <sql:update dataSource="${dbsource}" var="count">
            update product set pname = ?, quantity = ? where id='${param.id}'
            <sql:param value="${param.pname}"></sql:param>
            <sql:param value="${param.qty}"></sql:param>
        </sql:update>
        <c:if test="${count>=1}">
            <font size="5" color="green">Congratulations ! Data updated successfully.</font>
            <a href="index.jsp">Go Home</a>
        </c:if>
    </body>
</html>
