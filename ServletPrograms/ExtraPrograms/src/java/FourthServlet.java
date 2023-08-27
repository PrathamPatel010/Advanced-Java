import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FourthServlet extends HttpServlet{
    
    String uname = "";
    public void init(){
        uname="CVM University";
    }
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();
        String college = context.getInitParameter("cname");
        out.println("<h1>College is: " + college + "<br>");
        out.println("University is: " + uname);
    }       
}