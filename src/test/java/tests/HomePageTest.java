package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void testSeleniumHomePageOpened() {
        String expectedResultTitle = "Selenium";
        String expectedResultUrl = "https://www.selenium.dev/";

        openBaseURL();

        String actualResultTitle = getTitle();
        String actualResultUrl = getCurrentURL();

        Assert.assertEquals(actualResultTitle, expectedResultTitle);
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
    }

}
