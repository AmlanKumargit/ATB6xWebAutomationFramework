package com.amlankumar.tests;

import com.amlankumar.base.CommonToAllTests;
import com.amlankumar.pages.pageFactory.Login_PF;
import com.amlankumar.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.amlankumar.drivers.DriverManager.driver;

public class TestVWOLogin_PF_DM extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_withLogs.class);

    @Test
    public void VWONegative() throws FileNotFoundException {

        Login_PF loginPf = new Login_PF(driver);
        logger.info("Starting test -- Opening URL");
        loginPf.openVWOLoginURL("qa");
        logger.info("Logging in");
        String error_msg_text = loginPf.loginToVWOInvalidCreds();
        logger.info("Verifying result");
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");
        Assertions.assertThat(error_msg_text).isNotNull().isNotBlank();
    }

}
