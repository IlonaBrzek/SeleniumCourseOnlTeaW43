package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoSearchResultsPage {
    private WebDriver driver;

    public DuckDuckGoSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getTextsFromResultsLinks() {
        List<WebElement> resultsLinks = driver.findElements(By.cssSelector("ol.react-results--main li article h2 a"));
        List<String> result = new ArrayList<>();
        for(WebElement we : resultsLinks) {
            result.add(we.getText());
        }

        return result;
    }

}
