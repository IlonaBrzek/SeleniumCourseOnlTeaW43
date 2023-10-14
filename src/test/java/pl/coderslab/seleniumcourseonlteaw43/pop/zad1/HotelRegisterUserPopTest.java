package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw43.Util;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelRegisterUserPopTest {
    private WebDriver driver;

    @Test
    public void createUserAccount() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        HotelMainPage mainPage = new HotelMainPage(driver);
        mainPage.clickSignIn();

        HotelAuthenticationPage authenticationPage = new HotelAuthenticationPage(driver);
        final String randomEmail = Util.generateRandomEmail();
        authenticationPage.fillCreateAnAccount(randomEmail + Keys.ENTER);

        HotelCreateAnAccountPage createAnAccountPage = new HotelCreateAnAccountPage(driver);
        UserData userData = new UserData()
                .setFirstName("ala")
                .setLastName("makota")
                .setMr(false)
                .setPassword("alamakota123")
                .setSignUpForNewsletter(true);

        createAnAccountPage.fillForm(userData);
        createAnAccountPage.clickRegisterButton();

        HotelMyAccountPage myAccountPage = new HotelMyAccountPage(driver);
        assertTrue(myAccountPage.isAccountCreationSuccessPanelDisplayed());
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
