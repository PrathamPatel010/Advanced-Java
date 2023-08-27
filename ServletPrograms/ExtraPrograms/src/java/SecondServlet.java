import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet{
    String message = "";
    public void init(ServletConfig config){
        message="Hello World I am there";
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String email = req.getParameter("mail");
        out.println("Hello! " + email);
    }       
}