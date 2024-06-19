package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.BasePage;
import org.example.pages.LoginPageFacebook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoggerTest.class);

    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"test@gmail.com", "777","Неправильный пароль.\n" +
                        "Забыли его?"}
        };
    }

    @Test(dataProvider = "data")
    public void dataProviderTest(String email, String password,String errorMessage) throws Exception {

        LoginPageFacebook loginPageFacebook = new LoginPageFacebook();
        loginPageFacebook.openUrlFacebook();
        LoginPageFacebook facebookPage = new LoginPageFacebook();

        Thread.sleep(3000);
        loginPageFacebook.typeEmail(email);
        loginPageFacebook.typePassword(password);
        Thread.sleep(3000);
        facebookPage.clickSingInBtn();
        Assert.assertEquals(facebookPage.getTextErrorMessage(),errorMessage);
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warning");
        LOGGER.error("error");
    }
}
