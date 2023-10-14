package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DuckDuckGoSearchPopTest {
    private WebDriver driver;

    @Test
    public void searchWithDdg() {
        // given
        driver.get("https://duckduckgo.com/");
        // when
        DuckDuckGoMainPage ddgMainPage = new DuckDuckGoMainPage(driver);
        final String searchPhrase = "w pustyni i w puszczy";
        ddgMainPage.fillSearchInput(searchPhrase);
        ddgMainPage.clickSearchButton();
        // then
        DuckDuckGoSearchResultsPage ddgResultsPage = new DuckDuckGoSearchResultsPage(driver);
        List<String> textsFromResultsLinks = ddgResultsPage.getTextsFromResultsLinks();
//        textsFromResultsLinks.forEach(System.out::println);
        for (int i = 0; i < 3; i++) {
            String linkTextLower = textsFromResultsLinks.get(i).toLowerCase();
            String searchPhraseLower = searchPhrase.toLowerCase();
            if (!linkTextLower.contains(searchPhraseLower)) {
                Assertions.fail(String.format("search result should contain: %s, but was: %s", searchPhraseLower, linkTextLower));
            }
        }
    }

    @Test
    public void searchWithDdgEnter() {
        driver.get("https://duckduckgo.com/");
// when
        final String searchPhrase = "w pustyni i w puszczy";
        DuckDuckGoMainPage ddgMainPage = new DuckDuckGoMainPage(driver);
        ddgMainPage.fillSearchInput(searchPhrase + Keys.ENTER);

// then
        DuckDuckGoSearchResultsPage ddgResultsPage = new DuckDuckGoSearchResultsPage(driver);
        List<String> textsFromResultsLinks = ddgResultsPage.getTextsFromResultsLinks();
        for (int i = 0; i < 3; i++) {
            String linkTextLower = textsFromResultsLinks.get(i).toLowerCase();
            String searchPhraseLower = searchPhrase.toLowerCase();
            if (!linkTextLower.contains(searchPhraseLower)) {
                Assertions.fail(String.format("search result should contain: %s, but was: %s", searchPhraseLower, linkTextLower));
            }
        }
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterEach
    public void afterEach() {
        this.driver.quit();
    }
}
