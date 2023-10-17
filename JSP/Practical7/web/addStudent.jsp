<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
</head>
<body>
    <h2>Add Student</h2>
    <form action="/add" method="post">
        <label for="enrollmentNo">Enrollment No:</label>
        <input type="text" id="enrollmentNo" name="enrollmentNo" required><br>
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" required><br>
        <label for="semester">Semester:</label>
        <input type="text" id="semester" name="semester" required><br>
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" required><br>
        <label for="percentage">Percentage:</label>
        <input type="text" id="percentage" name="percentage" required><br>
        <input type="submit" value="Add">
    </form>
    <h3>Student added</h3>
    <br>
</body>
</html>
