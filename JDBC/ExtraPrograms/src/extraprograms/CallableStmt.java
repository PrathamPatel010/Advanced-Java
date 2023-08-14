package extraprograms;
import java.sql.*;
import java.util.Scanner;

public class CallableStmt {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvmu","root","");
            Statement stmt = conn.createStatement();
            System.out.println("Enter ID: ");
            int ID = in.nextInt();
            CallableStatement cs = conn.prepareCall("{call getName(?,?)}");
            cs.setInt(1, ID);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            System.out.println("Name of student is: " + cs.getString(2));
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
