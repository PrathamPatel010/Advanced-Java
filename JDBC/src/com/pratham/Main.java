package com.pratham;
import java.sql.*;
import java.util.*;

public class Main {
    private static final String DB_URI = "jdbc:mysql://127.0.0.1:3306/mbit";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URI,"root","");

            Scanner in = new Scanner(System.in);
            boolean exit = false;

            while (!exit){
                System.out.println("-------Choices------");
                System.out.println("1.Add Student");
                System.out.println("2.View Students");
                System.out.println("3.Edit Student");
                System.out.println("4.Delete Student");
                System.out.println("5.Search Student");
                System.out.println("6.Exit");
                System.out.println("Enter your choice:");

                int choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1 -> addStudent(conn, in);
                    case 2 -> viewStudents(conn);
                    case 3 -> editStudent(conn, in);
                    case 4 -> deleteStudent(conn, in);
                    case 5 -> searchStudent(conn, in);
                    case 6 -> exit = true;
                    default -> System.out.println("Invalid Choice");
                }
                System.out.println();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void addStudent(Connection conn, Scanner in) {
        System.out.println("Enter 3-digit ID: ");
        int ENR = in.nextInt();
        in.nextLine();
        System.out.println("Enter name: ");
        String name = in.nextLine();
        try{
            String query = "insert into student (ID,Name) values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,ENR);
            stmt.setString(2,name);
            stmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Student added successfully");
    }

    private static void viewStudents(Connection conn) {
        String query = "select * from student";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                System.out.println("ID:" + id + " Name:" + name);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void editStudent(Connection conn, Scanner in) {
        System.out.println("Enter 3-digit ID to edit student");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter new name: ");
        String newName = in.nextLine();
        String query = "update student set Name=? where ID=?";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,newName);
            stmt.setInt(2,id);
            stmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Student updated successfully");
    }

    private static void searchStudent(Connection conn, Scanner in) {
        System.out.println("Enter 3-digit ID to search student: ");
        int id = in.nextInt();
        in.nextLine();
        String query = "select * from student where ID=?";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                System.out.println("Student not found");
                return;
            }
            id = rs.getInt("ID");
            String name = rs.getString("Name");
            System.out.println("Student Found!!");
            System.out.println("ID:" + id + " Name:" + name);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent(Connection conn, Scanner in) {
        System.out.println("Enter 3-digit ID to delete student");
        int id = in.nextInt();
        String query = "delete from student where ID=?";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Student deleted successfully");
            } else{
                System.out.println("Student not found!!");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}