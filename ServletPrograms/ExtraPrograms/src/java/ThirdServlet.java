import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ThirdServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int n1 = Integer.parseInt(req.getParameter("n1"));
        int n2 = Integer.parseInt(req.getParameter("n2"));
        int max = Math.max(n1,n2);
        out.println("Maximum no is: " + max);
    }       
}