package com.amlankumar.base;

import com.amlankumar.drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTests {

    @BeforeMethod
    public void SetUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void TearDown(){
        DriverManager.down();
    }

}
