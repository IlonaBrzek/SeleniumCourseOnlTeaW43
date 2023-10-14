package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw43.Util;

import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.coderslab.seleniumcourseonlteaw43.Util.assertDisplayedAndEnabled;

public class HotelRegisterUserPopTest {
    private WebDriver driver;

    @Test
    public void createUserAccount() {
        // main page
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        HotelMainPage mainPage = new HotelMainPage(driver);
        mainPage.clickSignIn();

        HotelAuthenticationPage authenticationPage = new HotelAuthenticationPage(driver);
        final String randomEmail = Util.generateRandomEmail();
        authenticationPage.fillCreateAnAccount(randomEmail + Keys.ENTER);
//        // CREATE AN ACCOUNT
//        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
//        assertDisplayedAndEnabled(firstNameInput);
//        firstNameInput.sendKeys("ala");
//        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
//        assertDisplayedAndEnabled(lastNameInput);
//        lastNameInput.sendKeys("makota");
//        WebElement passwordInput = driver.findElement(By.id("passwd"));
//        assertDisplayedAndEnabled(passwordInput);
//        passwordInput.sendKeys("alamakota123");
//        WebElement submitButton = driver.findElement(By.id("submitAccount"));
//        assertDisplayedAndEnabled(submitButton);
//        submitButton.click();
//        // MY ACCOUNT
//        WebElement accountCreationSuccessPanel = driver.findElement(By.cssSelector("p.alert.alert-success"));
//        String panelText = accountCreationSuccessPanel.getText();
//        assertEquals("Your account has been created.", panelText);
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterEach
    public void afterEach() {
        System.out.println("driver.quit() commented!");
//        this.driver.quit();
    }
}
