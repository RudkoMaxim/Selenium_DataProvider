package org.example.pages;

import java.util.List;

import org.example.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/div/div[1]/button") // кнопка добавления товара в корзину
    private WebElement addBtn;

    @FindBy(xpath = ("//*[@class=\"sc-124al1g-4 eeXMBo\"][1]")) // поиск на странице первого продукта
    private WebElement actualTitle;

    @FindBy(xpath = ("//*[@class=\"sc-11uohgb-2 elbkhN\"]"))  // поиск наименования товара, добавленного в корзину
    private WebElement expectedTitle;

    @FindBy(xpath = "//*[text()='Add to cart']")  // кнопка добавления товара в корзину
    private List<WebElement> listBtn;

    @FindBy(xpath = "//button[@class='sc-1h98xa9-0 gFkyvN']")  // кнопка закрытия корзины (Х)
    private WebElement cartBtn;

    @FindBy(css = ".sc-124al1g-4.eeXMBo.sc-124al1g-4.eeXMBo")  // наименование товара на странице
    private List<WebElement> namesElements;

    @FindBy(xpath = "//p[@class = 'sc-11uohgb-2 elbkhN']") // кнопка перехода в корзину
    private List<WebElement> names2Elements;

    @FindBy(xpath = "//*[@class = \"checkmark\"] [text()='S']")  // кнопка фильтра по размеру "S"
    private WebElement sizeBtn;

    @FindBy (xpath = "//*[@class = 'sc-ebmerl-4 iliWeY']/p") // заголовок с количеством товаров до применения фильтра
    public List<WebElement> listOfProductsNaming;

    @FindBy (xpath = "//*[@class = 'sc-ebmerl-4 iliWeY']/p") // заголовок с количеством товаров после применения фильтра
    public List<WebElement> sizeListOfProductsNaming;

    @FindBy(xpath = "//*[text()='follow me on Linkedin.']") // кнопка перехода на Linkedin
    private WebElement linkedinBtn;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void openUrl() {
        DriverManager.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public void clickAddBtn() {
        addBtn.click();
    }

    public String getTextActualTitle() {
        return actualTitle.getText();
    }

    public String getTextExpectedTitle() {
        return expectedTitle.getText();
    }

    public List<WebElement> listBtn() {
        return listBtn;
    }

    public void clickCartBtn() {
        cartBtn.click();
    }

    public List<WebElement> namesElements() {
        return namesElements;
    }

    public List<WebElement> names2Elements() {
        return names2Elements;
    }

    public void clickSizeBtn() {
        sizeBtn.click();
    }

    public void clicklinkedinBtn() {
        linkedinBtn.click();
    }
}

