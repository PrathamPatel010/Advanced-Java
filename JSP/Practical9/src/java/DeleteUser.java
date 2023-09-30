import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteUser extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        try{
            PrintWriter out = res.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userreg","root","");
            String username = req.getParameter("username");
            String query = "delete from user where username=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                req.setAttribute("message", "User Deleted Successfully");
                req.getRequestDispatcher("deleteUser.jsp").forward(req, res);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}