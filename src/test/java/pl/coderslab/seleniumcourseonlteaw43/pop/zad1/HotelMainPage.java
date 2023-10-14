package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMainPage {
    @FindBy(css = "a.user_login.navigation-link")
    private WebElement signInButton;

    public HotelMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signInButton.click();
    }
}
