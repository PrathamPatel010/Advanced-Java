<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Students</title>
</head>
<body>
    <h2>List of Students</h2>
    <table border="1">
        <tr>
            <th>Enrollment No</th>
            <th>Student Name</th>
            <th>Semester</th>
            <th>Department</th>
            <th>Percentage</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>140</td>
                <td>Pratham Patel</td>
                <td>5</td>
                <td>CE</td>
                <td>96</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
