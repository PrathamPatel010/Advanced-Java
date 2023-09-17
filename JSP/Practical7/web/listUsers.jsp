<%@page import="java.util.ArrayList"%>
<%@page import="Util.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Users</title>
    </head>
    <body>
        <h1>List of Users</h1>
        <table border="1" >
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Mobile No.</th>
                <th>Password</th>
            </tr>
            <%
                ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
                for(User user : users){
            %>
            <tr>
                <td><%= user.getUsername()%></td>
                <td><%= user.getEmail()%></td>
                <td><%= user.getMobile()%></td>
                <td><%= user.getPassword()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
