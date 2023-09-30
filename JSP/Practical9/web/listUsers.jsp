<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Users</title>
    </head>
    <body>
        <h1>List of Users</h1>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Mobile No.</th>
                <th>Password</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.mobile}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
