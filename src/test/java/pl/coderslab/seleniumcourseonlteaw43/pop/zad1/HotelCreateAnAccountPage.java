package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pl.coderslab.seleniumcourseonlteaw43.Util.assertDisplayedAndEnabled;

public class HotelCreateAnAccountPage {
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;

    public HotelCreateAnAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterButton() {
//        assertDisplayedAndEnabled(submitButton);
        registerButton.click();
    }

    public void fillForm(UserData userData) {
//        assertDisplayedAndEnabled(firstNameInput);
        firstNameInput.sendKeys(userData.getFirstName());
//        assertDisplayedAndEnabled(lastNameInput);
        lastNameInput.sendKeys(userData.getLastName());
//        assertDisplayedAndEnabled(passwordInput);
        passwordInput.sendKeys(userData.getPassword());
    }
}
