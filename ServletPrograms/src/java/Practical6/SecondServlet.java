package Practical6;

import java.io.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        try{
            Student student1 = (Student)getServletContext().getAttribute("student1");
            Student student2 = (Student)getServletContext().getAttribute("student2");
            Student student3 = (Student)getServletContext().getAttribute("student3");
            Student student4 = (Student)getServletContext().getAttribute("student4");
            Student student5 = (Student)getServletContext().getAttribute("student5");
            res.setContentType("text/html");
            out.println("Roll number from Servlet1 to Servlet2<br>");
            out.println("Roll no 1: " + student1.getRollNo() + "<br>");
            out.println("Roll no 2: " + student2.getRollNo() + "<br>");
            out.println("Roll no 3: " + student3.getRollNo() + "<br>");
            out.println("Roll no 4: " + student4.getRollNo() + "<br>");
            out.println("Roll no 5: " + student5.getRollNo() + "<br>");
        } catch(Exception e){
            out.println(e);
        }
    }
}