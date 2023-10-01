package pl.coderslab.seleniumcourseonlteaw43;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchExamplesTest {
    @Test
    public void searchById() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocation = driver.findElement(By.id("hotel_location"));
        assertNotNull(hotelLocation);
        hotelLocation.sendKeys("Bukareszt");
        WebElement searchNow = driver.findElement(By.id("search_room_submit"));
        assertNotNull(searchNow);
        WebElement newsletterInputEmail = driver.findElement(By.id("newsletter-input"));
        assertNotNull(newsletterInputEmail);
        newsletterInputEmail.sendKeys("ala@makota.pl");

    }

    @Test
    public void searchByName() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement elem = driver.findElement(By.name("hotel_location"));
        assertNotNull(elem);
        // todo finish
    }

    @Test
    public void searchByClassName() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement elem = driver.findElement(By.className("user_login"));
        assertNotNull(elem);
        // todo finish
    }

    @Test
    public void searchByCssSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement elem = driver.findElement(By.cssSelector("a.user_login.navigation-link"));
        assertNotNull(elem);
        // todo finish
    }
}
