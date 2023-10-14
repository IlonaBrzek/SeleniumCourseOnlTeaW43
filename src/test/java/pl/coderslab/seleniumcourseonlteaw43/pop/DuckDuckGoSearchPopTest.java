package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DuckDuckGoSearchPopTest {
    @Test
    public void searchWithDdg() {
        // given
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
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
        //driver.quit();
    }

    @Test
    public void searchWithDdgEnter() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
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
}
