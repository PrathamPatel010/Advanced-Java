package Practical5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmailServlet extends HttpServlet {
    String personalMail="";
    String collegeMail="";
    public static int appHitCount=0;
    private int servletHitCount=0;
    public void init(ServletConfig config){
        try{
            super.init(config);
            personalMail = config.getInitParameter("email");
            ServletContext context = getServletContext();
            collegeMail = context.getInitParameter("collegeEmail");
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        servletHitCount++;
        appHitCount++;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try{
            out.println("Personal Mail: " + personalMail + "<br>");
            out.println("College Mail: " + collegeMail + "<br>");
            out.println("App Hit count: " + appHitCount + "<br>");
            out.println("Servlet Hit count: " + servletHitCount + "<br>");            
        } catch(Exception e){
            out.println(e);
        }
    }
}