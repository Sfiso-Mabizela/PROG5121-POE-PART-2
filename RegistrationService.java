/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationservice;

/**
 *
 * @author Sfiso
 */
 import java.util.Scanner;

   public class RegistrationService { public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
String user;
String pass;
String cell;                

 String firstName;
 String lastName;
 String loginUser;
 String loginPass;




              System.out.println("\n==== Welcome to NewGenCom ====\n");

    System.out.print("Enter User: ");
    user = input.nextLine();

    System.out.print("Enter Password: ");
    pass = input.nextLine();

    System.out.print("Enter [SA] Cell Number: ");
    cell = input.nextLine();

    // UserName conditions
    if(!(user.contains("_") && user.length() <=5)){
        System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
    }else {
        System.out.println("User name successfully captured");
    }

    // Password conditions
    boolean hasCap = !
            pass.equals(pass.toLowerCase());
    boolean hasNum = pass.matches(".*\\d.*");
    boolean hasSpecial = pass.matches(".*[!@#$%^&*()].*");
    if(pass.length() >= 8 && hasCap && hasNum && hasSpecial){
        System.out.println("Password successfully captured");
    }else{
        System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        return;
    }



    // Cell Number conditions

      //--- REFERENCE FOR TASK 1 (b) ---
      //This regular expression was researched to validate
      //SA international phone format (+27)
      //Source: Oracle Java Documentation - Pattern Class
      //Link: https://docs.oracle.com/javase/8/docs/api/java/util/regex/pattern.html
      String cellRegex = "^\\+27\\d{9}$";

    if(cell.matches(cellRegex)){
        System.out.println("Cell phone number successfully added");
    }else {
        System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
    }

System.out.println("\n====LOGIN====\n");
    System.out.print("Enter First Name: ");
    firstName = input.nextLine();


    System.out.print("Enter Last Name: ");
    lastName = input.nextLine();


    System.out.print("Enter Username: ");
    loginUser = input.nextLine();

    System.out.print("Enter Password: ");
    loginPass = input.nextLine();

if(loginUser.equals(user) && loginPass.equals(pass)){
    System.out.print("\nWelcome " + firstName + ", " + lastName + " it is great to see you again.\n");
}else{
    System.out.print("Username or password incorrect, please try again.");

}
  
//We start by checking if the user succesfully logged in 
    Login loginObj = new Login();
   boolean loginSucceeded = loginObj.loginUser(loginUser, user, loginPass, pass);
  
   if(loginSucceeded){
   System.out.println("\nWelcome to QuickChat\n");
   
 //this variable will remember the very last message you sent   
   String lastMessage = "No message sent yet.";
   
 
 //We ask the user how many messsages they want to handle in this session  
   System.out.println("How many messages do you wish to enter? ");
        int numMessage = input.nextInt();
                         input.nextLine();
        
             //counter keeps tracks of how many messages we've finished            
             int messageSent = 0;
   
   
  
   int choice = 0;
   
 //This loops keeps the menue running untill you choose quit or reach limit  
   while (choice != 3 && messageSent < numMessage){
       System.out.println("\n---Main Menu---");
       
       System.out.println("1] Send a Message");
       
       System.out.println("2] Show sent message");
       
       System.out.println("3] Quit");
       
       System.out.println("Select an option");
   
       
         choice = input.nextInt();
                   input.nextLine();
     if (choice == 1){
       //collecting message from the user
         System.out.println("Who are you sending to?");
            String recipient = input.nextLine();
    
            
     System.out.println("Enter your message");
      String msg = input.nextLine();
        //We create a new 'message' object to hold this specific data
       Messsage msgObj = new
              Messsage(recipient, msg);
   //Logic check: does the number start with +27 and is the message short enough?
      if(recipient.startsWith("+27") && recipient.length() <=13 && msg.length() <=250){ 
   
  
      
      System.out.println("\nMessage ID: " + msgObj.getMessageID());
          System.out.println("Message hash: " + msgObj.getMessageHash());
      System.out.println("Recipient :" + recipient);
       System.out.println("Message :" + msg);
     //Final action send, discard, or store
       System.out.println("\n1] Send Message\n2] Disregard\n3] Store\n"); 
      
      
      int finalAction = input.nextInt();
                         input.nextLine();
      if (finalAction == 1){
          System.out.println("Message successfully sent");
       // count this as a completed message 
          messageSent++;
          
          lastMessage = "Sent to: " + recipient + "\nMessages: " + msg;
            System.out.println(">>>>Message sent!<<<<");
              System.out.println("Message sent to " + recipient);
      
      
      }else if(finalAction == 2){
        System.out.println("Press 0 to delete the messege");
      
      
      }else if(finalAction == 3){
           System.out.println("Message succesfully stored");
            messageSent++;
      
      }else{  
     System.out.println("invalid menue option");
      }
      
      
      }else{
          // output of incorrect work
          System.out.println("Please enter a message of less than 250 characters.");
          System.out.println("Error: check recipient format (+27 and max 10 chars).");
      }
     
      
    } else if(choice == 2){
        System.out.println("Feature coming soon!!......");
    }
           
   
   }
      System.out.println("Total messages sent during session: " + messageSent);
   }
   }
}
   
   
   
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
