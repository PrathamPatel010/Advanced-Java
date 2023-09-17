<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>

    <body>
        <h1>Create a User</h1>
        <form action="CreateUser" method="post">
            Username: <input type="text" name="username" required><br> Email:
            <input type="email" name="email" required> <br> Mobile:
            <input type="number" name="mobile" required><br> Password: <input type="password" name="password" required><br>
            <button type="submit">Create a User</button>
        </form>

        <div>
            <% String message = (String)request.getAttribute("message");%>
                <% if(message!=null){ %>
                    <p>
                        <%= message%>
                    </p>
                    <%}%>
        </div>
    </body>

    </html>