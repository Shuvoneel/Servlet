

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<!DOCTYPE HTML>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication Page</title>
    </head>

    <body>
        <c:if test="${ empty param.username or empty param.password}">
            <c:redirect url="login.jsp" >
                <c:param name="errMsg" value="Please Enter UserName and Password" />
            </c:redirect>

        </c:if>

        <c:if test="${not empty param.username and not empty param.password}">
            <s:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                             url="jdbc:mysql://localhost:3306/jstlshuvo"
                             user="root" password="1234"/>

            <s:query dataSource="${db}" var="sq">
                select count(*) as counts from users
                where username='${param.username}'
                and password='${param.password}'
            </s:query>

            <c:forEach items="${sq.rows}" var="r">
                <c:choose>
                    <c:when test="${r.counts gt 0}">
                        <c:set scope="session" var="loginUser" value="${param.username}"/>
                        <c:redirect url="index.jsp"/>
                    </c:when>

                    <c:otherwise>
                        <c:redirect url="login.jsp" >
                            <c:param name="errMsg" value="Username/password does not match" />
                        </c:redirect>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

        </c:if>

    </body>
</html>