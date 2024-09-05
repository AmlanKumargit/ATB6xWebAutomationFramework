package com.amlankumar.tests;

import com.amlankumar.pages.pageFactory.Login_PF;
import com.amlankumar.pages.pageObjectModel.Login_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestVWOLogin_PF {

    @Test
    public void TestVWONegative() throws FileNotFoundException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");
        Login_PF loginPf = new Login_PF(driver);
        String error_msg_text = loginPf.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
    }
}
