package com.amlankumar.tests;

import com.amlankumar.base.CommonToAllTests;
import com.amlankumar.pages.pageFactory.Login_PF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.amlankumar.drivers.DriverManager.driver;

public class TestVWOLogin_withLogs extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_withLogs.class);

    @Test
    public void VWONegative() throws FileNotFoundException {
        logger.info("Starting test");
        Login_PF loginPf = new Login_PF(driver);
        logger.info("Opening URL");
        loginPf.openVWOLoginURL("qa");
        String error_msg_text = loginPf.loginToVWOInvalidCreds();
        logger.info("Verifying result");
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
    }
}
