package com.amlankumar.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StaleElementException {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        WebElement search_textarea = driver.findElement(By.name("q"));
        driver.navigate().refresh();
        search_textarea = driver.findElement(By.name("q")); //override the element again to prevent StaleElementException
        search_textarea.sendKeys("thetestingacademy");
        driver.quit();

    }
}
