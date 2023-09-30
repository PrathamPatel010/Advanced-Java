<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User</title>
    </head>
    <body>
        <h1>Delete a User</h1>
        <form action="DeleteUser" method="post">
            Enter Username to delete:<input type="text" name="username" id="username" value="${user.username}"><br><br>
            <button type="submit">Delete User</button>
        </form>
        
        <div>
            <c:if test="${not empty message}">
                <p>User Deleted Successfully</p>
            </c:if>
        </div>
    </body>
</html>
