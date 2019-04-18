
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*, java.sql.*, java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/jstlshuvo"
                           user="root" password="1234"></sql:setDataSource>
        <sql:query dataSource="${dbsource}" var="result">
            select * from product where id=?;
            <sql:param value="${param.id}"></sql:param>
        </sql:query>
        <form action="updatedb.jsp" method="post">
            <table border="0" width="40%">
                <caption>Update Product</caption>
                <tr>
                    <td>Product Name</td>
                    <td>Quantity</td>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><input type="hidden" name="id" value="${param.id}">
                            <input type="text" name="pname" value="${row.pname}"></td>
                        <td><input type="text" name="qty" value="${row.quantity}"></td>
                        <td><input type="submit" value="Update"></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="index.jsp">Go Home</a>
        </form>
    </body>
</html>
