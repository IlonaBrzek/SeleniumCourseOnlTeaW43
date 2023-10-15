package pl.coderslab.seleniumcourseonlteaw43.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw43.pop.DuckDuckGoMainPage;
import pl.coderslab.seleniumcourseonlteaw43.pop.DuckDuckGoSearchResultsPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class SearchWithDuckDuckGoSteps {
    private WebDriver driver;
    private DuckDuckGoMainPage ddgMainPage;
    private DuckDuckGoSearchResultsPage ddgResultsPage;

    @Given("Page {word} opened in browser")
//    @Given("^Page (.*) opened in browser$")
    public void pageOpenedInBrowser(String url) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.driver.get(url);
        this.ddgMainPage = new DuckDuckGoMainPage(driver);
        this.ddgResultsPage = new DuckDuckGoSearchResultsPage(driver);
    }

    @When("Phrase {string} entered in search input box")
    public void enterPhrase(String searchPhrase) {
        ddgMainPage.fillSearchInput(searchPhrase);
    }

    @And("Search button clicked")
    public void clickSearchButton() {
        ddgMainPage.clickSearchButton();
    }

    @Then("First {int} search result text contain phrase {string}")
    public void resultsShouldContainPhrase(int count, String searchPhrase) {
        List<String> textsFromResultsLinks = ddgResultsPage.getTextsFromResultsLinks();
        for (int i = 0; i < count; i++) {
            String linkTextLower = textsFromResultsLinks.get(i).toLowerCase();
            String searchPhraseLower = searchPhrase.toLowerCase();
            if (!linkTextLower.contains(searchPhraseLower)) {
                Assertions.fail(String.format("search result should contain: %s, but was: %s", searchPhraseLower, linkTextLower));
            }
        }
    }

    @And("Save screenshot")
    public void saveScreenshot() throws IOException {
        //Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copy the screenshot to desired location
        //Path to the location to save screenshot
        //(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        // new three classes that we use below: Files, Path, Paths
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "ddg-search-"+currentDateTime+".png"));
    }

    @And("Close browser")
    public void closeBrowser() {
        this.driver.quit();
    }
}
