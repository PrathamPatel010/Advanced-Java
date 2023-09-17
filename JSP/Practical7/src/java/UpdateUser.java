import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateUser extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userreg","root","");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            long mobile = Long.parseLong(req.getParameter("mobile"));
            String password = req.getParameter("password");
            String query = "update user set email=?,mobile=?,password=? where username=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(4, username);
            pstmt.setString(1, email);
            pstmt.setLong(2, mobile);
            pstmt.setString(3, password);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                req.setAttribute("message", "User updated Successfully");
                req.getRequestDispatcher("updateUser.jsp").forward(req, res);
            }
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }
}
