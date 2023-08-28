package Practical3;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SearchStudent extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        PrintWriter out = res.getWriter();
        try{
            res.setContentType("text/html");
            HttpSession hs = req.getSession();
            out.println("Session ID: " + hs.getId() + "<br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbit","root","");
            String query = "select * from student where ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            int Enroll = Integer.parseInt(req.getParameter("enrollmentNo"));
            ps.setInt(1,Enroll);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                out.println("<h1>Student Info </h1><br>");
                out.println("Enrollment: " + rs.getInt(1) + " Name: " + rs.getString(2) + "</h1>");
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }
}