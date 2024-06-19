package org.example.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import java.util.List;

public class ElementActionListener implements WebDriverListener {
    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Open url https://react-shopping-cart-67954.firebaseapp.com/");
    }
    @Override
    public void afterClick(WebElement element) {
        System.out.println("Click on " + element.getTagName() + " element");
    }
    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("Get text from element " + element.getTagName());
    }
    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        System.out.println("Find element " + element.getTagName() + " on page");
    }
}

