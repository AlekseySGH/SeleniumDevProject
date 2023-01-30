package tests;

import base.BaseTest;
import base.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomePageTest extends BaseTest {

    private final By NAVIGATION_BAR = By.xpath("//div[@id='main_navbar']/ul/li");

    private final By NAVIGATION_BAR_LINK = By.xpath(
            "//div[@id='main_navbar']/ul/li[@class='nav-item mr-4 mb-2 mb-lg-0']");

    private final By LOGO_IMAGE = By.xpath("//header/nav//span[@class='navbar-logo']");

    private final By ABOUT_DROPDOWNMENU = By.xpath("//div[@class='dropdown-menu show']/a");

    private final By LANGUAGE_DROPDOWNMENU = By.xpath("//div[@class='dropdown-menu show']/a");

    private final By ABOUT_BUTTON = By.xpath("//div//li/a[text() = 'About']");

    private final By LANGUAGE_BUTTON = By.xpath("//div//li/a[text() = 'English']");

    private final By SEARCH_FIELD = By.xpath("//div[@id='docsearch']");


    @Test
    public void testSeleniumHomePageOpened() {
        final String expectedResultTitle = "Selenium";
        final String expectedResultUrl = getBaseUrl();

        openBaseURL();

        String actualResultTitle = getTitle();
        String actualResultUrl = getCurrentURL();

        Assert.assertEquals(actualResultTitle, expectedResultTitle);
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
    }

    @Test
    public void testVerifyAllElementsOfNavigationBarAreVisible() {

        final List<String> expectedNavigationBarElements = Arrays.asList(
                "About",
                "Downloads",
                "Documentation",
                "Projects",
                "Support",
                "Blog",
                "English"
        );

        openBaseURL();
        List<String> actualNavigationBarElements = getListOfElementsText(NAVIGATION_BAR);

        Assert.assertTrue(isElementExists(LOGO_IMAGE));
        Assert.assertTrue(isElementExists(SEARCH_FIELD));
        Assert.assertEquals(actualNavigationBarElements, expectedNavigationBarElements);
    }

    @Test
    public void testLogoExistsAndClickableUserAndStartPageRefresh() {

        openBaseURL();
        click(LOGO_IMAGE);

        Assert.assertTrue(isElementExists(LOGO_IMAGE));
        Assert.assertTrue(isElementEnabled(LOGO_IMAGE));
        Assert.assertEquals(getCurrentURL(), getBaseUrl());
    }

    @Test
    public void testVerifyAllElementsOfAboutDropdownMenuAreVisible() {

        final List<String> expectedNavigationBarElements = Arrays.asList(
                "About Selenium",
                "Structure and Governance",
                "Events",
                "Ecosystem",
                "History",
                "Get Involved",
                "Sponsors"
        );

        openBaseURL();
        click(ABOUT_BUTTON);

        List<String> actualNavigationBarElements = getListOfElementsText(ABOUT_DROPDOWNMENU);

        Assert.assertEquals(actualNavigationBarElements, expectedNavigationBarElements);
    }

    @Test
    public void testVerifyAllElementsOfLanguageDropdownMenuAreVisible() {

        final List<String> expectedNavigationBarElements = Arrays.asList(
                "Português (Brasileiro)",
                "中文简体",
                "日本語",
                "Other"
        );

        openBaseURL();
        click(LANGUAGE_BUTTON);

        List<String> actualNavigationBarElements = getListOfElementsText(LANGUAGE_DROPDOWNMENU);

        Assert.assertEquals(actualNavigationBarElements, expectedNavigationBarElements);
    }

    @Test(dataProvider = "TopMenuMainPage", dataProviderClass = TestData.class)
    public void testTopMenuNavigateToCorrespondingPage(
            int index, String iconName, String href, String expectedURL, String expectedTitle) {

        openBaseURL();

        final String oldTitle = getTitle();
        final String oldURL = getCurrentURL();

        clickForDataProvider(NAVIGATION_BAR_LINK, index);

        String actualTitle = getTitle();
        String actualURL = getCurrentURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dataProvider = "AboutDropdownMenuMainPage", dataProviderClass = TestData.class)
    public void aboutDropdownMenuButtonsTestDataProvider(
            int index, String iconName, String href, String expectedURL, String expectedTitle) {

        openBaseURL();

        final String oldTitle = getTitle();
        final String oldURL = getCurrentURL();

        click(ABOUT_BUTTON);
        clickForDataProvider(ABOUT_DROPDOWNMENU, index);

        String actualTitle = getTitle();
        String actualURL = getCurrentURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTitle, actualTitle);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
