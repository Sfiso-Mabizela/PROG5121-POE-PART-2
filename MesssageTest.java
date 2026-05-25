/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sfiso
 */

 
public class MesssageTest {
    
    public MesssageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createMessageHash method, of class Messsage.
     */
 

    // TASK: Test Recipient Number (SUCCESS)
    @Test
    public void testRecipientSuccess() {
        Messsage instance = new Messsage("+27718659002", "Valid");
        String expResult = "Cell phone number successfully captured.";
       assertEquals(expResult, instance.checkRecipientCell());
    }

    // TASK: Test Recipient Number (FAILURE)
    @Test
    public void testRecipientFailure() {
        Messsage instance = new Messsage("08575975889", "Invalid");
        String expResult = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
       assertEquals(expResult, instance.checkRecipientCell());
    }

    // TASK: Test Message Length (SUCCESS)
    @Test
    public void testMessageLengthSuccess() {
        Messsage instance = new Messsage("+27718659002", "Hi Mike, join us for dinner?");
        //String expResult = "Message ready to send.";
      // assertEquals(expResult, instance.getMessage());
    }

    // TASK: Test Message Length (FAILURE)
    @Test
    public void testMessageLengthFailure() {
        // Creates a string over 250 characters
        String longMsg = "a".repeat(251); 
        Messsage instance = new Messsage("+27718659002", longMsg);
    // String result = instance.getMessage();
      // assertTrue(result.contains("Message exceeds 250 characters"));
    }

    // TASK: Test Message ID (Created)
    @Test
    public void testMessageIDCreated() {
        Messsage instance = new Messsage("+27718659002", "ID Test");
        assertNotNull(instance.getMessageID());
    }

    // TASK: Test Message Hash (Created)
    @Test
    public void testMessageHashCreated() {
        Messsage instance = new Messsage("+27718659002", "Hash Test");
        assertNotNull(instance.createMessageHash());
    }

@Test
public void testRecipient() {
    Messsage instance = new Messsage("+27718659002", "Valid");
    assertEquals("Cell phone number successfully captured.", instance.checkRecipientCell());
}

@Test
public void testMessageLength() {
    Messsage instance = new Messsage("+27718659002", "Short message");
    assertEquals("Message ready to send.", instance.getMessageStatus());
}


}


