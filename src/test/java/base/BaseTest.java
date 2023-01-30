package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utils.ReportUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    private final static String BASE_URL = "https://www.selenium.dev/";

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

//    public List<WebElement> getListOfElements(By by) {
//
//        return getDriver().findElements(by);
//    }

    public List<WebElement> getListOfElements(By by) {

        List<WebElement> ListOfElements = new ArrayList<>();

        for (WebElement element : getDriver().findElements(by)) {
            if (element.isEnabled() && element.isDisplayed()) {

                ListOfElements.add(element);
            }
        }
        return ListOfElements;
    }

    protected List<String> getListOfElementsText(By by) {

        List<WebElement> list = getListOfElements(by);

        List<String> textList = new ArrayList<>();

        if (list.size() > 0) {
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {

                    textList.add(element.getText());
                }
            }
            return textList;
        }
        return new ArrayList<>();
    }

    public boolean isElementExists(By by) {
        boolean isExists = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isExists = false;
        }

        return isExists;
    }

    public boolean isElementEnabled(By by) {

        return getDriver().findElement(by).isEnabled();
    }

    public void click(By by) {

        getDriver().findElement(by).click();
    }

    public void clickForDataProvider(By by, int index) {

        getListOfElements(by).get(index).click();

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
