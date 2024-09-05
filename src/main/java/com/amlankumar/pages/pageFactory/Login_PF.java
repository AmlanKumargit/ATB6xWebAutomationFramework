package com.amlankumar.pages.pageFactory;

import com.amlankumar.base.CommonToAllPages;
import com.amlankumar.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class Login_PF extends CommonToAllPages {
    WebDriver driver;
    public Login_PF(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    public String loginToVWOInvalidCreds() throws FileNotFoundException {

        /*username.sendKeys(user);
        password.sendKeys(pwd);
        signButton.click();*/

        enterInput(username, PropertyReader.readKey("invalid_username"));
        enterInput(password, PropertyReader.readKey("invalid_password"));
        clickElement(signButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return error_message.getText();
    }

}
