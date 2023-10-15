package pl.coderslab.seleniumcourseonlteaw43.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw43.pop.DuckDuckGoMainPage;
import pl.coderslab.seleniumcourseonlteaw43.pop.DuckDuckGoSearchResultsPage;

import java.time.Duration;
import java.util.List;

public class SearchWithDuckDuckGoSteps {
    private WebDriver driver;
    private DuckDuckGoMainPage ddgMainPage;
    private DuckDuckGoSearchResultsPage ddgResultsPage;
    private final String searchPhrase = "w pustyni i w puszczy";

    @Given("Page https:\\/\\/duckduckgo.com\\/ opened in browser")
    public void pageOpenedInBrowser() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.driver.get("https://duckduckgo.com/");
        this.ddgMainPage = new DuckDuckGoMainPage(driver);
        this.ddgResultsPage = new DuckDuckGoSearchResultsPage(driver);
    }

    @When("Phrase 'w pustyni i w puszczy' entered in search input box")
    public void enterPhrase() {
        ddgMainPage.fillSearchInput(searchPhrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        ddgMainPage.clickSearchButton();
    }

    @Then("First 3 search result text contain phrase 'w pustyni i w puszczy'")
    public void resultsShouldContainPhrase() {
        List<String> textsFromResultsLinks = ddgResultsPage.getTextsFromResultsLinks();
        for (int i = 0; i < 3; i++) {
            String linkTextLower = textsFromResultsLinks.get(i).toLowerCase();
            String searchPhraseLower = searchPhrase.toLowerCase();
            if (!linkTextLower.contains(searchPhraseLower)) {
                Assertions.fail(String.format("search result should contain: %s, but was: %s", searchPhraseLower, linkTextLower));
            }
        }
    }

    @And("Close browser")
    public void closeBrowser() {
        System.out.println("close browser!");
//        this.driver.quit();
    }
}
