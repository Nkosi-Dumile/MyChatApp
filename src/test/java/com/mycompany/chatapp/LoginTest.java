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
public class LoginTest {
@Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Kyle", "Name");
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Name");
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Kyle", "Name");
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordFailsComplexity() {
        Login login = new Login("Kyle", "Name");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testPhoneNumberCorrectlyFormatted() {
        Login login = new Login("Kyle", "Name");
        assertTrue(login.checkCellPhoneNumber("+27839658976"));
    }

    @Test
    public void testPhoneNumberIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Name");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}


