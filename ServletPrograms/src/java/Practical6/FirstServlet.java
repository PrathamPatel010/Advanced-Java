package Practical6;

import java.io.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        try{
            Student s1 = new Student();
            Student s2 = new Student();
            Student s3 = new Student();
            Student s4 = new Student();
            Student s5 = new Student();
            s1.setRollNo(138);
            s2.setRollNo(139);
            s3.setRollNo(140);
            s4.setRollNo(141);
            s5.setRollNo(142);
            req.getServletContext().setAttribute("student1", s1);
            req.getServletContext().setAttribute("student2", s2);
            req.getServletContext().setAttribute("student3", s3);
            req.getServletContext().setAttribute("student4", s4);
            req.getServletContext().setAttribute("student5", s5);
            out.println("5 Roll numbers assigned in Servlet1");
        } catch(Exception e){
            out.println(e);
        }
    }
}