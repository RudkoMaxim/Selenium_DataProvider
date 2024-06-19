package org.example;
import org.example.listeners.TestListeners;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverManager.getDriver();
    }
    @AfterMethod
    public void closeSession(){
        DriverManager.quitDriver();
    }
}
