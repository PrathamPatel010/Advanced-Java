<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <h1>Update a User</h1>
        <form action="UpdateUser" method="post">
            Enter Username: <input type="text" name="username" id="username" value="${user.username}" required><br><br>
            Enter New-Email:<input type="email" name="email" id="email" value="${user.email}" required> <br><br>
            Enter New-Mobile:<input type="number" name="mobile" id="mobile" value="${user.mobile}" required><br><br>
            Enter New-Password: <input type="password" name="password" id="password" value="${user.password}" required><br><br>
        <button type="submit">Update a User</button>
        </form>
        
        <div>
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
        </div>
    </body>
</html>
