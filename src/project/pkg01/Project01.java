package project.pkg01;

import java.sql.*;
import java.util.Scanner;

public class Project01 {

       private Connection conn;
       private Statement stmt;
       private ResultSet rs;

    public Project01() {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem?zeroDateTimeBehavior=convertToNull","root",""); //Make Connection to the Database
            stmt = conn.createStatement();            
          }catch(SQLException e){
            System.err.println(e);
            e.printStackTrace();
          }
    }     
    public static void main(String[] args) {
       
        Scanner objUser = new Scanner(System.in); //Create a scanner object called objUser
        
        boolean WrongChoice = false; //User Select wrong option
        boolean Continuation = true; //User wants to continue the program
        String decision = null; //User select whether close the program or not
        boolean wrongDecision = false; //User Select wrong option
        
        System.out.println("|||||||||||||||WELCOME TO STUDENT MANAGEMENT SYSTEM|||||||||||||||");
    }
    
}
