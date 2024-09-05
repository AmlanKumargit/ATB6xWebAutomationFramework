package com.amlankumar.tests;

import com.amlankumar.base.CommonToAllTests;
import com.amlankumar.pages.pageFactory.Login_PF;
import com.amlankumar.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.amlankumar.drivers.DriverManager.driver;

public class TestVWOLogin_PF_DM extends CommonToAllTests {

    @Test
    public void VWONegative() throws FileNotFoundException {
        Login_PF loginPf = new Login_PF(driver);
        loginPf.openVWOLoginURL("qa");
        String error_msg_text = loginPf.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
    }
}
