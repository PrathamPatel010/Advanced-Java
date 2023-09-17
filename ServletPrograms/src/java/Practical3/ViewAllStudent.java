package Practical3;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import static Practical5.EmailServlet.appHitCount;
public class ViewAllStudent extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        PrintWriter out = res.getWriter();
        try{
            appHitCount++;
            res.setContentType("text/html");
            HttpSession hs = req.getSession();
            out.println("Session ID: " + hs.getId() + "<br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbit","root","");
            Statement stmt = conn.createStatement();
            String query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);
            out.println("<h1>View All Student </h1><br>");
            while(rs.next()){
                out.println("Enrollment: " + rs.getInt(1) + " Name: " + rs.getString(2) + "<br>");
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }
}