package pl.coderslab.seleniumcourseonlteaw43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.coderslab.seleniumcourseonlteaw43.Util.assertDisplayedAndEnabled;

public class HotelRegisterUserTest {

    @Test
    public void searchByCssSelector() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        // main page
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement signInLink = driver.findElement(By.cssSelector("a.user_login.navigation-link"));
        signInLink.click();
        // sign in page
        WebElement emailInput = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID().toString() + "@mail.pl";
        emailInput.sendKeys(randomEmail + Keys.ENTER);
        // CREATE AN ACCOUNT
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        assertDisplayedAndEnabled(firstNameInput);
        firstNameInput.sendKeys("ala");
        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        assertDisplayedAndEnabled(lastNameInput);
        lastNameInput.sendKeys("makota");
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        assertDisplayedAndEnabled(passwordInput);
        passwordInput.sendKeys("alamakota123");
        WebElement submitButton = driver.findElement(By.id("submitAccount"));
        assertDisplayedAndEnabled(submitButton);
        submitButton.click();
        // MY ACCOUNT
        WebElement accountCreationSuccessPanel = driver.findElement(By.cssSelector("p.alert.alert-success"));
        String panelText = accountCreationSuccessPanel.getText();
        assertEquals("Your account has been created.", panelText);
    }
}
