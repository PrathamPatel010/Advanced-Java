package Practical3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewAllStudent extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession hs = req.getSession();
        out.println("Session ID: " + hs.getId() + "<br>");
        out.println("Students will be printed here..." + "<br>");
    }
}