package Practical3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddStudent extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        try{
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            HttpSession hs = req.getSession();
            out.println("Session ID: " + hs.getId() + "<br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbit","root","");
            String query = "insert into student values(?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            int Enroll = Integer.parseInt(req.getParameter("enrollmentNo"));
            String name = req.getParameter("name");
            ps.setInt(1,Enroll);
            ps.setString(2,name);
            ps.execute();
            out.println("Student added: " + Enroll + " : " + name);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}