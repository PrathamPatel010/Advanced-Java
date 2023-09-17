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
        Enter Username: <input type="text" name="username" required><br>
        <button type="submit">Delete a User</button>
        </form>
        
        <div>
            <% String message = (String)request.getAttribute("message");%>
            <% if(message!=null){ %>
            <p><%= message%></p>
            <%}%>
        </div>
    </body>
</html>
