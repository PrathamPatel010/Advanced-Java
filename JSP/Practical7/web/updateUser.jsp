<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <h1>Update a User</h1>
        <form action="UpdateUser" method="post">
        Enter Username: <input type="text" name="username" required><br>
        Enter New-Email:<input type="email" name="email" required> <br>
        Enter New-Mobile:<input type="number" name="mobile" required><br>
        Enter New-Password: <input type="password" name="password" required><br>
        <button type="submit">Update a User</button>
        </form>
        
        <div>
            <% String message = (String)request.getAttribute("message");%>
            <% if(message!=null){ %>
            <p><%= message%></p>
            <%}%>
        </div>
    </body>
</html>
