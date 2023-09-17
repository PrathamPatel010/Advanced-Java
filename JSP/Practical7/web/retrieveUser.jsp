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
        Enter Username to retrieve a user: <input type="text" name="username" required><br>
        <button type="submit">Find a User</button>
        </form>
        
        <div>
            <% String message = (String)request.getAttribute("message");%>
            <% if(message!=null){ %>
            <% String username = (String)request.getAttribute("name");%>
            <% String email = (String)request.getAttribute("email");%>
            <% long mobile = (Long)request.getAttribute("mobile");%>
            <% String password = (String)request.getAttribute("password");%>
            <p><%= message%></p>
            <p><%= username%></p>
            <p><%= email%></p>
            <p><%= mobile%></p>
            <p><%= password%></p>
            <%}%>
        </div>
    </body>
</html>
