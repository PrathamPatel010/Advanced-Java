import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class CreateUser extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userreg","root","");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            long mobile = Long.parseLong(req.getParameter("mobile"));
            String password = req.getParameter("password");
            String query = "insert into user values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setLong(3, mobile);
            pstmt.setString(4, password);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                req.setAttribute("message", "User added Successfully");
                req.getRequestDispatcher("createUser.jsp").forward(req, res);
            } 
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }
}