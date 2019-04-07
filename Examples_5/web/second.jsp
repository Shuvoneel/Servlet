
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Second Page</title>
    </head>
    <body>
        <h1>Second Page</h1>
        <%

            String name = (String) session.getAttribute("n");
            out.print("Hello " + name);

        %> 
    </body>
</html>
