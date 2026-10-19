/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Random;

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
        if (recipientCell != null && recipientCell.length() <= 10 && recipientCell.startsWith("+")) {
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
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                return "Message successfully stored.";
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
}


