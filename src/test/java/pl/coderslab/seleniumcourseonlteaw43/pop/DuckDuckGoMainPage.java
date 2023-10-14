package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DuckDuckGoMainPage {
    private WebDriver driver;

    public DuckDuckGoMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillSearchInput(String searchPhrase) {
        WebElement searchInput = driver.findElement(By.id("searchbox_input"));
        searchInput.sendKeys(searchPhrase);
    }

    public void fillSearchInputAndEnter(String searchPhrase) {
        WebElement searchInput = driver.findElement(By.id("searchbox_input"));
        searchInput.sendKeys(searchPhrase + Keys.ENTER);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.className("searchbox_searchButton__F5Bwq"));
        searchButton.click();
    }
}
