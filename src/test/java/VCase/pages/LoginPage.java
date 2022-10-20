package VCase.pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Helper {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "ap_email")
    public WebElement emailField;
    @FindBy(id = "ap_password")
    public WebElement passwordField;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(id = "signInSubmit")
    public WebElement signInSubmitBtn;
    @FindBy(xpath = "//form[@name='signIn']//h1[@class='a-spacing-small']")
    public WebElement signInHeaderText;

    public void typeEmail(String email) {
        sendKeysElement(emailField, email);
    }

    public void typePassword(String password) {
        sendKeysElement(passwordField, password);
    }

    public void clickContinueBtn() {
        clickElement(continueBtn);
    }
    public void clickSignInSubmitBtn() {
        clickElement(signInSubmitBtn);
    }

    public void isLogOutSuccessfull() {
        Assert.assertTrue(isDisplayed(signInHeaderText));
    }
}
