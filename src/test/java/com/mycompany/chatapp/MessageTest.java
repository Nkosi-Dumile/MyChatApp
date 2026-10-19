/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Student
 */
public class MessageTest {
    @Test
    public void testValidRecipientCell() {
        Message msg = new Message("+27839658976", "Hello World");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testInvalidRecipientCell() {
        Message msg = new Message("0839658976", "Hello World");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell());
    }

    @Test
    public void testValidMessageLength() {
        Message msg = new Message("+27839658976", "This is a short message.");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }

    @Test
    public void testMessageIDNotNull() {
        Message msg = new Message("+27839658976", "Test message ID");
        assertNotNull(msg.getMessageID());
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testMessageHashGenerated() {
        Message msg = new Message("+27839658976", "Test message hash");
        assertNotNull(msg.getMessageHash());
    }

    @Test
    public void testSentMessageChoices() {
        Message msg = new Message("+27839658976", "Test action choices");
        assertEquals("Message successfully sent.", msg.SentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
        assertEquals("Message saved to draft.", msg.SentMessage(3));
    }
    
}
