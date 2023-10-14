package pl.coderslab.seleniumcourseonlteaw43;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class Util {
    public static void assertDisplayedAndEnabled(WebElement elem) {
        if(!elem.isDisplayed() || !elem.isEnabled()) {
            Assertions.fail("element NOT displayed OR NOT enabled!");
        }
    }

    public static String generateRandomEmail() {
        return UUID.randomUUID().toString() + "@mail.pl";
    }

    public static void setCheckbox(WebElement checkbox, boolean isChecked) {
        if((isChecked && (checkbox.getAttribute("checked") == null)) ||
           (!isChecked && (checkbox.getAttribute("checked") != null))
        ) {
            checkbox.click();
        }
    }
}
