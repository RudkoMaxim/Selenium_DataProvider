package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.BasePage;
import org.example.utils.ScreenShotUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class reactShoppingPage extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoggerTest.class);

//  Тест 1
//  1. Найдите название первого продукта
//  2. Добавьте в корзину первый продукт
//  3. Сравните название продукта в корзине с названием продукта из первого пункта

    @Test
    public void test1() {
        BasePage basePage = new BasePage();
        basePage.openUrl();
        basePage.clickAddBtn();  // Находим на странице и добавляем в корзину первый продукт
        ScreenShotUtils.takeScreenshot(driver); // делаем скриншот
        Assert.assertEquals(basePage.getTextActualTitle(), basePage.getTextExpectedTitle());// Сравниваем название продукта в корзине с названием продукта из первого пункта

        LOGGER.info("info");
        LOGGER.error("error");
    }

//  Тест 2
//  1. Получите названия всех продуктов(используйте List)
//  2. Добавьте все продукты в корзину
//  3. Сравните все названия продуктов в корзине с листом из первого пункта

    @Test
    public void test2() {
        BasePage basePage = new BasePage();
        basePage.openUrl();
        List<WebElement> listBtn = basePage.listBtn();
        for (WebElement element : listBtn) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); // Добавляем все продукты в корзину
        }
        List<WebElement> names = basePage.namesElements();
        List<String> namesStr = names.stream().map(x -> x.getText()).toList(); // Получаем названия всех продуктов на странице
        List<WebElement> names2 = basePage.names2Elements();
        List<String> namesStr2 = names2.stream().map(x -> x.getText()).toList(); // Получаем названия всех продуктов в корзине
        Assert.assertEquals(namesStr, namesStr2, "Names are not equal"); // Сравниваем все названия продуктов в корзине с листом из первого пункта
        LOGGER.debug("debug");
        LOGGER.info("info");
    }

//  Тест 3
//  1. Получите названия всех продуктов(используйте List)
//  2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
//  3. Получите лист для текущих продуктов и сравните что его размер меньше листа из первого пункта

    @Test
    public void test3() throws InterruptedException {
        BasePage basePage = new BasePage();
        basePage.openUrl();
        List<WebElement> names = basePage.namesElements();
        List<String> namesStr = names.stream().map(x -> x.getText()).toList(); // Получаем названия всех продуктов на странице
        basePage.clickSizeBtn(); // Отфильтровываем продукты по размеру S
        Thread.sleep(1000);
        List<WebElement> names2 = basePage.names2Elements();
        List<String> namesStr2 = names2.stream().map(x -> x.getText()).toList(); // Получаем названия всех продуктов на странице после применения фильтра
        Assert.assertNotEquals(namesStr, namesStr2, "Lists are equal");  // Сравниваем размер листа до применения фильтра и после
        LOGGER.info("info");
        LOGGER.error("error");
    }

//  Тест 4
//  1. Получите количество продуктов расспарсив сверху стрингу  16 Product(s) found
//  2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
//  3. Получите количество продуктов после фильтра  расспарсив сверху стрингу   Product(s) found и сравните с числом из первого пункта

    @Test
    public void test4() throws InterruptedException {
        BasePage basePage = new BasePage();
        basePage.openUrl();
        List<String> allProductsList = basePage.listOfProductsNaming.stream().map(x->x.getText()).toList();
        basePage.clickSizeBtn();
        Thread.sleep(1000);
        List<String> sizeAllProductsList = basePage.sizeListOfProductsNaming.stream().map(x->x.getText()).toList();
        Assert.assertTrue(allProductsList != sizeAllProductsList, "Lists not equal");
        LOGGER.info("info");
        LOGGER.error("error");
    }
}