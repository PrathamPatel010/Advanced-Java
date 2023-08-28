package Practical3;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteStudent extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        try{
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            HttpSession hs = req.getSession();
            out.println("Session ID: " + hs.getId() + "<br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbit","root","");
            String query = "delete from student where ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            int Enroll = Integer.parseInt(req.getParameter("enrollmentNo"));
            ps.setInt(1,Enroll);
            ps.execute();
            out.println("Student deleted: " + Enroll);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}