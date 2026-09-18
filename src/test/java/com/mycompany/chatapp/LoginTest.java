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
        @Test
    public void testRegisterUserSuccess() {
        Login login = new Login("Kyle", "Name");
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27839658976");
        assertEquals("Username successfully captured.", actual);
    }

    @Test
    public void testLoginStatusSuccess() {
        Login login = new Login("Kyle", "Name");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27839658976");
        boolean isLogged = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        String actual = login.returnLoginStatus(isLogged);
        assertEquals("Welcome Kyle, Name it is great to see you.", actual);
    }

    @Test
    public void testLoginStatusFailure() {
        Login login = new Login("Kyle", "Name");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27839658976");
        boolean isLogged = login.loginUser("wrong_user", "wrong_pass");
        String actual = login.returnLoginStatus(isLogged);
        assertEquals("Username or password incorrect, please try again.", actual);
    
    }
    }


