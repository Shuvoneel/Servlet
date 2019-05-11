
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form id="loginForm" action="j_security_check" post="method">
            Username: <input type="text" name="j_username" id="j_username">
            Password: <input type="text" name="j_password" id="j_password">
            <button type="submit">Login</button>
        </form>
    </body>
</html>
