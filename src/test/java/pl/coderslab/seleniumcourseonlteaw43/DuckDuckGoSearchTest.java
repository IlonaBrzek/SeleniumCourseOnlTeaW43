package pl.coderslab.seleniumcourseonlteaw43;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckDuckGoSearchTest {
    @Test
    public void searchWithDdg() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.id("searchbox_input"));
        searchInput.sendKeys("w pustyni i w puszczy");
        WebElement searchButton = driver.findElement(By.className("searchbox_searchButton__F5Bwq"));
        searchButton.click();
        //driver.quit();
    }
}
