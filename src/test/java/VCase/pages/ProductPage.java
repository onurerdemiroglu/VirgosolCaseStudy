package VCase.pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ProductPage extends Helper {
    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "add-to-wishlist-button")
    public WebElement addToList;
    @FindBy(id = "productTitle")
    public WebElement productTitle;
    @FindBy(id = "huc-item-link")
    public WebElement titleAddedProduct;
    @FindBy(id = "continue-shopping")
    public WebElement continueShopping;

    public void addProductToList(String listName){
        By listLocator = By.xpath("//img[contains(@id,'atwl-list-profile-image') and @alt='" + listName + "']");
        clickElement(addToList);
        clickElement(listLocator);
    }

    public void isProductAddedToList() {
        Assert.assertEquals(getText(productTitle), getText(titleAddedProduct));
    }

    public void clickContinueShopping() {
        clickElement(continueShopping);
    }
}
