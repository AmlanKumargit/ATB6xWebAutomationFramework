package com.amlankumar.tests;

import com.amlankumar.pages.pageObjectModel.Login_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestVWOLogin_POM {

    @Test
    public void testVWONeg() {
        WebDriver driver = new EdgeDriver();
        Login_POM loginPagePom = new Login_POM(driver);
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds("admin@gmail.com", "admin@123");
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Test
    public void testVWONeg1() {
        WebDriver driver = new EdgeDriver();
        Login_POM loginPagePom = new Login_POM(driver);
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds("user@gmail.com", "user@123");
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        driver.quit();
    }
}
