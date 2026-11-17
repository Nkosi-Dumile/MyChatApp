/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Student
 */
public class Message {
     private String messageID;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    private static int totalMessagesSent = 0;
    
    // Parallel Arrays / Lists for Part 3 Storage & Reporting
    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static ArrayList<String> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> storedMessages = new ArrayList<>();
    private static ArrayList<String> messageHashes = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();
    private static ArrayList<String> recipients = new ArrayList<>();
    


    public Message(String recipientCell, String messageText) {
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        Random rand = new Random();
        long number = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipientCell != null && recipientCell.length() <= 12 && recipientCell.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength() {
        if (messageText == null || messageText.length() > 250) {
            int over = (messageText == null) ? 0 : messageText.length() - 250;
            return "Message exceeds 250 characters by " + over + "; please reduce the size.";
        }
        return "Message ready to send.";
    }

    public String createMessageHash() {
        if (messageID == null || messageText == null || messageText.trim().isEmpty()) {
            return "";
        }
        String firstTwoID = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (firstTwoID + ":" + totalMessagesSent + ":" + firstWord + lastWord).toUpperCase();
    }

    public String SentMessage(int choice) {
        switch (choice) {
       case 1:
                totalMessagesSent++;
                sentMessages.add(messageText);
                messageHashes.add(messageHash);
                messageIDs.add(messageID);
                recipients.add(recipientCell);
                return "Message successfully sent.";
            case 2:
                disregardedMessages.add(messageText);
                return "Press 0 to delete the message.";
            case 3:
                storedMessages.add(messageText);
                messageHashes.add(messageHash);
                messageIDs.add(messageID);
                recipients.add(recipientCell);
                return "Message saved to draft.";
            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {
        return "Message ID: " + messageID + "\n"
             + "Message Hash: " + messageHash + "\n"
             + "Recipient: " + recipientCell + "\n"
             + "Message: " + messageText;
    }

    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipientCell() { return recipientCell; }
    public String getMessageText() { return messageText; }
    
    public static ArrayList<String> getSentMessages() { return sentMessages; }
    public static ArrayList<String> getStoredMessages() { return storedMessages; }
    public static ArrayList<String> getDisregardedMessages() { return disregardedMessages; }
    public static ArrayList<String> getMessageHashes() { return messageHashes; }
    public static ArrayList<String> getMessageIDs() { return messageIDs; }
    public static ArrayList<String> getRecipients() { return recipients; }

}


