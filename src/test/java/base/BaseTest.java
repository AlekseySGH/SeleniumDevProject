package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utils.ReportUtils;

import java.lang.reflect.Method;

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
    protected void beforeMethod(Method method, ITestResult result, ITestContext context) {
        driver = BaseUtils.createDriver();

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
    }

    protected WebDriver getDriver() {

        return driver;
    }

}
