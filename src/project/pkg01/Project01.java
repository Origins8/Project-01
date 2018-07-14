package project.pkg01;

import java.sql.*;
import java.util.Scanner;

public class Project01 {
    
    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
       
        Scanner objUser = new Scanner(System.in); //Create a scanner object called objUser
        
        boolean WrongChoice = false; //User Select wrong option
        boolean Continuation = true; //User wants to continue the program
        String decision = null; //User select whether close the program or not
        boolean wrongDecision = false; //User Select wrong option
        
        System.out.println("|||||||||||||||WELCOME TO STUDENT MANAGEMENT SYSTEM|||||||||||||||");

        try{
            
            Class.forName("com.mysql.jdbc.Driver");//Register JDBC Driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem?zeroDateTimeBehavior=convertToNull","root","");//open a connection
            stmt = conn.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         while(Continuation == true){
            
           if(WrongChoice == false){
                
                System.out.println("\nWhich operation do you want to do?\n\t1-Add new Student\n\t2-Get all Student informations\n\t3-Get one Student information\n");
                int UserChoice = objUser.nextInt(); //Get the input from the user 

                switch (UserChoice) {
                    case 1:
                        System.out.print("\nEnter Student ID        : ");
                        String id = objUser.next();
                        System.out.print("Enter Student name      : ");
                        String name = objUser.next();
                        System.out.print("Enter Student Age       : ");
                        String age = objUser.next();
                        System.out.print("Enter Student address   : ");
                        String address = objUser.next();
                        
                        try{
                            
                            String insert = "INSERT INTO student(ID, NAME, AGE, ADDRESS)" + "VALUES ()";
                            stmt.executeUpdate(insert);
                            
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try{
                            
                            String all = "SELECT * FROM `student`";
                            stmt.executeUpdate(all);
                            
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        System.out.println("Enter Student ID        : ");
                        id = objUser.next();
                        
                        try{
                            
                            String personal = "SELECT * FROM `student` WHERE ID=id";
                            stmt.executeUpdate(personal);
                            
                        }catch(Exception e){
                            e.printStackTrace();
                        }   
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
