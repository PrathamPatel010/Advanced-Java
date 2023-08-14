package extraprograms;
import java.sql.*;
public class FirstProgram {
    public static void main(String[] args) throws Exception{
        try{
            // Step-1:Load the Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Step-2:Connect to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvmu","root","");
            
            // Step-3:Create the statement & Executing Query
            Statement stmt = conn.createStatement();
            String query = "insert into student values(140,'Pratham Patel',9.56)";
            stmt.execute(query);
            query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);
            
            // Step-4:Process the results
            while(rs.next()){
                System.out.println("ID:" + rs.getInt("ID") + " Name:" + rs.getString("Name") + " CGPA:" + rs.getFloat("CGPA"));
            }
            
            // Step-5:Terminate the sessions
            rs.close();
            stmt.close();
            conn.close();
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}