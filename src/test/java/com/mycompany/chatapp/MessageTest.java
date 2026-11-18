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
    
    @Test
    public void testDisplayLongestMessage() {
        String expected = "Where are you? You are late! I have asked you to be on time.";
        String actual = Message.getLongestStoredMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchMessageByID() {
        String result = Message.searchMessageByID("0838884567");
        assertTrue(result.contains("It is dinner time!"));
    }

    @Test
    public void testSearchMessagesByRecipient() {
        String result = Message.searchMessagesByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageByHash() {
        String result = Message.deleteMessageByHash("0838884567"); 
        assertTrue(result.contains("successfully deleted"));
    }

    @Test
    public void testDisplayReport() {
        String report = Message.generateSentMessagesReport();
        assertTrue(report.contains("Message Hash") || report.contains("ID"));
        assertTrue(report.contains("Recipient"));
    }
}
