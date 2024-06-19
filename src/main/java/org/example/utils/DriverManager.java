package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.Capability;
import org.example.listeners.ElementActionListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
        if (localDriver.get() == null) {
            driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
            driver = decorator.decorate(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            localDriver.set(driver);
            return driver;
        } else {
            return localDriver.get();
        }
    }

    public static void quitDriver() {
        localDriver.get().quit();
        localDriver.set(null);
    }
}