package Practical3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SearchStudent extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession hs = req.getSession();
        out.println("Session ID: " + hs.getId() + "<br>");
        long Enroll = Long.parseLong(req.getParameter("enrollmentNo"));
        out.println(Enroll + "<br>");
    }
}