package Practical3;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditStudent extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        PrintWriter out = res.getWriter();
        try{
            res.setContentType("text/html");
            HttpSession hs = req.getSession();
            out.println("Session ID: " + hs.getId() + "<br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbit","root","");
            String query = "update student set Name=? where ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            int Enroll = Integer.parseInt(req.getParameter("enrollmentNo"));
            String newName = req.getParameter("name");
            ps.setString(1,newName);
            ps.setInt(2,Enroll);
            ps.execute();
            out.println("Student Updated: "+Enroll + "<br> New Name is: " + newName);
        }
        catch(Exception e){
            out.println(e);
        }
    }
}