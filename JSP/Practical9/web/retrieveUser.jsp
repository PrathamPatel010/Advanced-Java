<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retrieve User</title>
    </head>
    <body>
        <h1>Retrieve a User</h1>
        <form action="RetrieveUser" method="post">
            Enter Username to retrieve a user: <input type="text" name="username" required><br><br>
            <button type="submit">Find a User</button>
        </form>
        
        <div>
            <c:if test="${not empty message}">
                <h4>${message}</h4>
            </c:if>
                
            <c:if test="${not empty user}">
                <p>Username: ${user.getString("username")} </p>
                <p>Email: ${user.getString("email")} </p>
                <p>Mobile: ${user.getLong("mobile")} </p>
                <p>Password: ${user.getString("password")} </p>
            </c:if>
        </div>
    </body>
</html>