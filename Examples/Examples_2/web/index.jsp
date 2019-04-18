
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <!--Declaration Tag--->
        <%!
            String fname = "Mehedi";
            String lname = "Hasan";
        %>
        <h2> <!--Expression Tag--->
            <%= "First name: " + fname%>
        </h2>

        <h2> <!--Scriptlet Tag--->
            <%
                out.println("Last name: " + lname);
            %>
        </h2>
        <%
            int x = 10;
            int y = 5;
            int sum = x + y;

            out.print("Sum: " + sum);
        %>
        <%!
            int x = 20;
        %>
        <%="X: " + x%>

    </body>
</html>
