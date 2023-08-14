package Practical2;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayData extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(10);
        PrintWriter out = res.getWriter();
        out.println("Session ID: " + session.getId());
        out.println("Session Creation time: " + session.getCreationTime());
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        out.println("Name is: " +name);
        out.println("Age is: " + age);
    }
}