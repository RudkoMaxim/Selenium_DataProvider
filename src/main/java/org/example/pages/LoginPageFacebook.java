package org.example.pages;

import org.example.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageFacebook extends BasePage {
    public void openUrlFacebook() {
        DriverManager.getDriver().get("https://www.facebook.com/?locale=ru_RU");
    }
    public LoginPageFacebook() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = ("//*[@class= 'inputtext _55r1 _6luy']"))
    private WebElement emailInput;

    @FindBy(xpath = ("//*[@class= 'inputtext _55r1 _6luy _9npi']"))
    private WebElement passwordInput;

    @FindBy(xpath = ("//*[@class= '_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"))
    private WebElement singInBtn;

    @FindBy(xpath = ("//*[@class = '_9ay7']"))
    private WebElement errorMessege;

    public void typeEmail(String email){
        emailInput.sendKeys(email);
    }

    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickSingInBtn() {
        singInBtn.click();
    }
    public String getTextErrorMessage() {
        return errorMessege.getText();
    }
}
