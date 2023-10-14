package pl.coderslab.seleniumcourseonlteaw43.pop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoSearchPopTest {
    @Test
    public void searchWithDdg() {
        // given
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        // when
        DuckDuckGoMainPage ddgMainPage = new DuckDuckGoMainPage(driver);
        ddgMainPage.fillSearchInput("w pustyni i w puszczy");
        ddgMainPage.clickSearchButton();
        // then
        // assert
        //driver.quit();
    }

    @Test
    public void searchWithDdgEnter() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");

        DuckDuckGoMainPage ddgMainPage = new DuckDuckGoMainPage(driver);
        ddgMainPage.fillSearchInput("w pustyni i w puszczy" + Keys.ENTER);
    }
}
