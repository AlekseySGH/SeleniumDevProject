package base;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "TopMenuMainPage")
    public static Object[][] topMenuButtonsTestDataProvider() {

        return new Object[][]{
                {0, "Downloads", "/downloads", "https://www.selenium.dev/downloads/", "Downloads | Selenium"},
                {1, "Documentation", "/documentation", "https://www.selenium.dev/documentation/", "The Selenium Browser Automation Project | Selenium"},
                {2, "Projects", "/projects", "https://www.selenium.dev/projects/", "Projects | Selenium"},
                {3, "Support", "/support", "https://www.selenium.dev/support/", "Support | Selenium"},
                {4, "Blog", "/blog", "https://www.selenium.dev/blog/", "Blog | Selenium"}

        };
    }

    @DataProvider(name = "AboutDropdownMenuMainPage")
    public static Object[][] aboutDropdownMenuButtonsTestDataProvider() {

        return new Object[][]{
                {0, "About Selenium", "/about", "https://www.selenium.dev/about/", "About Selenium | Selenium"},
                {1, "Structure and Governance", "/project", "https://www.selenium.dev/project/", "Structure and Governance | Selenium"},
                {2, "Events", "/events", "https://www.selenium.dev/events/", "Events | Selenium"},
                {3, "Ecosystem", "/ecosystem", "https://www.selenium.dev/ecosystem/", "Ecosystem | Selenium"},
                {4, "History", "/history", "https://www.selenium.dev/history/", "History | Selenium"},
                {5, "Get Involved", "/getinvolved", "https://www.selenium.dev/getinvolved/", "Get Involved | Selenium"},
                {6, "Sponsors", "/sponsors", "https://www.selenium.dev/sponsors/", "Sponsors | Selenium"}

        };
    }
}
