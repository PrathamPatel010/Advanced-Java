<%@page import="Utils.Student" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>
    <h1>Set Roll No.</h1>
    <form method="post" action="SetStudent">
        Roll No. <input type="text" name="rollNo">
        <button type="submit">Set Roll No</button>
    </form>
    
    <hr>
    <h2>Student Information</h2>
    <p>
        <% Student student = (Student)request.getAttribute("student");%>
        <% if(student!=null) { %>
        Roll Number is: <%= student.getRollNo() %>
        <% } else { %>
        Student is not set currently
        <% }%>
    </p>
</body>
</html>