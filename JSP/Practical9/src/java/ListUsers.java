import java.io.*;
import java.util.ArrayList;
import Util.User;
import java.sql.*;
import javax.servlet.http.*;

public class ListUsers extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out = res.getWriter();
        ArrayList<User> users = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userreg","root","");
            String query = "select * from user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4));
                users.add(user);
            }
            req.setAttribute("users", users);
            req.getRequestDispatcher("listUsers.jsp").forward(req, res);
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }
}
