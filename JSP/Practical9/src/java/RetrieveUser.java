import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RetrieveUser extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userreg","root","");
            String username = req.getParameter("username");
            String query = "select * from user where username=? ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                req.setAttribute("message", "Information Retrieved");
                req.setAttribute("user", rs);
                req.getRequestDispatcher("retrieveUser.jsp").forward(req, res);
            } else{
                req.setAttribute("message", "User Not Found!!");
            }
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }
}