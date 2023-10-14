package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelAuthenticationPage {
    @FindBy(id = "email_create")
    private WebElement emailInput;

    public HotelAuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillCreateAnAccount(String input) {
        emailInput.sendKeys(input);
    }
}
