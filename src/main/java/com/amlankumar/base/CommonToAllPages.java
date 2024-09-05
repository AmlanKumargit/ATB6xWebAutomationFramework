package com.amlankumar.base;

import com.amlankumar.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;

import static com.amlankumar.drivers.DriverManager.getDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;


public class CommonToAllPages {

    public CommonToAllPages() {
    }

    public void openVWOLoginURL(String url) throws FileNotFoundException {

            switch (url){
                case "qa":
                    getDriver().get(PropertyReader.readKey("qa_url"));
                    break;
                case "preprod":
                    getDriver().get(PropertyReader.readKey("uat_url"));
                    break;
                default:
                    getDriver().get(PropertyReader.readKey("url"));
                    break;
        }

    }

    // For POM elements
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    // For PF elements
    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }



    // Waits

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement element) {
        return element;
    }
}
