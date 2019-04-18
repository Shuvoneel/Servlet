<jsp:useBean id="person" class="JavaBeansAndEL.Person">
    <jsp:setProperty name="person" property="*"/>

</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Name: ${person.name}
        Age: ${person.age}
        Email: ${person.email}

        <form action="simpleBean.jsp">
            <label>Enter a Name:</label>
            <input type="text" name="name">
            <label>Enter an Age:</label>
            <input type="text" name="age">
            <label>Enter an Email:</label>
            <input type="email" name="email">
            <input type="submit" name="Send">

        </form>
    </body>
</html>
