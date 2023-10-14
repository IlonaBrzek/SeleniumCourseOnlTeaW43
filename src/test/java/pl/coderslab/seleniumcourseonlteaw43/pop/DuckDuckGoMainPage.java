package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuckDuckGoMainPage {
    @FindBy(id = "searchbox_input")
    private WebElement searchInput;
    @FindBy(className = "searchbox_searchButton__F5Bwq")
    private WebElement searchButton;

    public DuckDuckGoMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillSearchInput(String searchPhrase) {
        searchInput.sendKeys(searchPhrase);
    }

    public void fillSearchInputAndEnter(String searchPhrase) {
        searchInput.sendKeys(searchPhrase + Keys.ENTER);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
