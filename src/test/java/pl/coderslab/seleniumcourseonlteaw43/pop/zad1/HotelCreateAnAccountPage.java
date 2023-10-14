package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pl.coderslab.seleniumcourseonlteaw43.Util.assertDisplayedAndEnabled;
import static pl.coderslab.seleniumcourseonlteaw43.Util.setCheckbox;

public class HotelCreateAnAccountPage {
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "id_gender1")
    private WebElement radioButtonMr;
    @FindBy(id = "id_gender2")
    private WebElement radioButtonMrs;

    public HotelCreateAnAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterButton() {
        assertDisplayedAndEnabled(registerButton);
        registerButton.click();
    }

    public void fillForm(UserData userData) {
        assertDisplayedAndEnabled(firstNameInput);
        assertDisplayedAndEnabled(lastNameInput);
        assertDisplayedAndEnabled(passwordInput);
//        assertDisplayedAndEnabled(radioButtonMr);
//        assertDisplayedAndEnabled(radioButtonMrs);
        assertDisplayedAndEnabled(newsletterCheckbox);

        if(userData.isMr()) {
            radioButtonMr.click();
        } else {
            radioButtonMrs.click();
        }
        firstNameInput.sendKeys(userData.getFirstName());
        lastNameInput.sendKeys(userData.getLastName());
        passwordInput.sendKeys(userData.getPassword());
        setCheckbox(newsletterCheckbox, userData.isSignUpForNewsletter());
    }
}
