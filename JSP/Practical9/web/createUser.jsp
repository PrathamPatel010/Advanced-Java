<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <h1>Create User</h1>
        <form action="CreateUser" method="post">
            Username: <input type="text" name="username" id="username" required><br><br>
            Email: <input type="email" name="email" id="email" required> <br><br>
            Mobile: <input type="number" name="mobile" id="mobile" required><br><br> 
            Password: <input type="password" name="password" id="password" required><br><br>
            <button type="submit">Create a User</button>
        </form>
        <div>
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
        </div>
    </body>
</html>
