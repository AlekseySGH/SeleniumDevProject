package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    final static String BASE_URL = "https://www.selenium.dev/";

    public static String getBaseUrl() {

        return BASE_URL;
    }

    public void openBaseURL() {

        driver.get(getBaseUrl());
    }

    public String getTitle() {

        return getDriver().getTitle();
    }

    public String getCurrentURL() {

        return getDriver().getCurrentUrl();
    }

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {

        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {

        driver.quit();
    }

    protected WebDriver getDriver() {

        return driver;
    }

}
