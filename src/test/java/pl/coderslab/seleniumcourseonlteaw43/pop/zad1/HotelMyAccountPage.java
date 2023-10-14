package pl.coderslab.seleniumcourseonlteaw43.pop.zad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMyAccountPage {
    @FindBy(css = "p.alert.alert-success")
    private WebElement accountCreationSuccessPanel;

    public HotelMyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountCreationSuccessPanelDisplayed() {
        return "Your account has been created.".equals(accountCreationSuccessPanel.getText());
    }
}
