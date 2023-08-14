package extraprograms;
import java.sql.*;
import java.util.Scanner;

public class PreparedStmt {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvmu","root","");
            Statement stmt = conn.createStatement();
            System.out.println("Enter ID: ");
            int ID = in.nextInt();
            System.out.println("Enter Name: ");
            String name = in.next();
            System.out.println("Enter CGPA: ");
            float cgpa = in.nextFloat();
            
            String query = "insert into student values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ID);
            ps.setString(2, name);
            ps.setFloat(3, cgpa);
            ps.execute();
            
            query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("ID:" + rs.getInt("ID") + " Name:" + rs.getString("Name") + " CGPA:" + rs.getFloat("CGPA"));
            }
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
