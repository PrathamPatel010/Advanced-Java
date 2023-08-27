import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
    String message = "";
    public void init(ServletConfig config){
        message="Hello World I am there";
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        out.println("<h1>Message is: " + message);
    }       
}