
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h1>Welcome Page</h1>
        <%
            out.print("Welcome " + request.getParameter("uname"));
            session.setAttribute("n", request.getParameter("uname"));
          
        %>  
        <a href="second.jsp">second jsp page</a>  
    </body>
</html>
