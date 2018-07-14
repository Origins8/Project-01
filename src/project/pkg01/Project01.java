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
        
         while(Continuation == true){
            
           if(WrongChoice == false){
                
                System.out.println("\nWhich operation do you want to do?\n\t1-Add new Student\n\t2-Get all Student informations\n\t3-Get one Student information\n");
                int UserChoice = objUser.nextInt(); //Get the input from the user 

                switch (UserChoice) {
                    case 1:
                        System.out.print("\nEnter Student ID       : ");
                        String id = objUser.next();
                        System.out.print("Enter Student name      : ");
                        String name = objUser.next();
                        System.out.print("Enter Student Age       : ");
                        String age = objUser.next();
                        System.out.print("Enter Student address   : ");
                        String address = objUser.next();
                        
                        String insert = "INSERT INTO student(ID, NAME, AGE, ADDRESS)" + "VALUES (?,?,?,?)";
                
                        break;
                    case 2:
                        
                        String all = "SELECT * FROM `student`";

                        break;
                    case 3:
                        
                        System.out.println("Enter Student ID        : ");
                        id = objUser.next();
                        String personal = "SELECT * FROM `student` WHERE ID=id";
                
                        break;
                    default:
                        System.out.println("Sorry your choice of action is incorrect. Please try again!");
                        WrongChoice = true;
                        break;
                }
           }  
            
            System.out.println("\nDo You want to continue? y-yes / n-No");
            decision = objUser.next();
            
            
            while(wrongDecision == true){
             switch (decision) {
               case "y":
                   Continuation = true;
                   wrongDecision = false;
                   break;
               case "n":
                   Continuation = false;
                   wrongDecision = false;
                   break;
               default:
                   System.out.println("Please enter the correct letter");
                   wrongDecision = true;
                   break;
            }   
          }
       }  
    }
}
