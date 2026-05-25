/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationservice;

/**
 *
 * @author Sfiso
 */
public class Messsage {
 
   private String messageID;
   private int numMessageSent;
   private String recipient;
   private String messageBody;
   private String messageHash;
  
   
   //Keeping track of how many messages Sent
   private static int totalMessagesCounter = 0;

public Messsage(String recipient, String messageBody){
    this.recipient = recipient;
    this.messageBody = messageBody;
    
    //Auto-generates the Id AND THE Hash when message is made
    this.messageID = generateID();
    this.messageHash = createMessageHash();

    //
    totalMessagesCounter++;
    this.numMessageSent = totalMessagesCounter;
    
  }

 private String generateID(){
       long min = 1000000000L;
       long max = 9999999999L;
       long randomID = (long)
       (Math.random()*(max - min + 1) + min);
      return String.valueOf(randomID);
      }

public String createMessageHash() {
    String idPart = messageID.substring(0, 3);
    
    
    String[] words = messageBody.split(" ");
    String firstWord = words[0].toUpperCase();
    String lastWord = words[words.length - 1].toUpperCase();

    return idPart + ":" + numMessageSent + " " + firstWord + lastWord;
}
public String getMessageID() {
    return messageID;
}
public String getMessageHash(){
    return messageHash;
}
public static int returnMessages(){
    return totalMessagesCounter;
}

public boolean isValidRecipient() {
    return this.recipient.startsWith("+27") && this.recipient.length() <= 10;
}

    Object getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


public String checkRecipientCell() {
    if (this.recipient.startsWith("+27") && this.recipient.length() <= 12) {
        return "Cell phone number successfully captured.";
    } else {
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
}


public String getMessageStatus() {
    if (this.messageBody.length() <= 250) {
        return "Message ready to send.";
    } else {
        int exceededBy = this.messageBody.length() - 250;
        return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
    }
}
}
 
