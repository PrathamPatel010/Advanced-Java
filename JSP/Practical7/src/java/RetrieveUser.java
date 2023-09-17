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
            String name="",email="",password="";
            long mobile=0;
            while(rs.next()){
                name=rs.getString(1);
                email=rs.getString(2);
                mobile=rs.getLong(3);
                password = rs.getString(4);
            }
            req.setAttribute("message","Information Retrieved");
            req.setAttribute("name",name);
            req.setAttribute("email", email);
            req.setAttribute("mobile", mobile);
            req.setAttribute("password", password);
            req.getRequestDispatcher("retrieveUser.jsp").forward(req, res);
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }
}