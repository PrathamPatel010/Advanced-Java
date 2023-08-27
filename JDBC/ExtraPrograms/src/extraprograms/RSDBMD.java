package extraprograms;
import java.sql.*;

// demonstrates use of ResultSetMetaData & DatabaseMetaData interfaces
public class RSDBMD {
    public static void main(String[] args) throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvmu","root","");
            
            // DatabaseMetaData
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Meta data of database: ");
            System.out.println(dbmd.getDatabaseProductName());
            System.out.println(dbmd.getDatabaseProductVersion());
            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getDriverVersion());
            System.out.println(dbmd.getURL());
            System.out.println(dbmd.getUserName());
            
            // ResultSetMetaData
            Statement stmt = conn.createStatement();
            String query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Meta data of ResultSet");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total Columns: " + rsmd.getColumnCount());
            System.out.println("First Column: " + rsmd.getColumnName(1) + " & Type: " + rsmd.getColumnTypeName(1));
            System.out.println("Last Column: " + rsmd.getColumnName(3) + " & Type: " + rsmd.getColumnTypeName(3));           
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}