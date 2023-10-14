package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoSearchResultsPage {
    @FindBy(css = "ol.react-results--main li article h2 a")
    private List<WebElement> resultsLinks;

    public DuckDuckGoSearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getTextsFromResultsLinks() {
        List<String> result = new ArrayList<>();
        for(WebElement we : resultsLinks) {
            result.add(we.getText());
        }

        return result;
    }
}
