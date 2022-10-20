package VCase.pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPage extends Helper {
    public ListPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".a-button-input")
    public WebElement createAListBtn;
    @FindBy(id = "list-name")
    public WebElement listNameInput;
    @FindBy(id = "wl-redesigned-create-list")
    public WebElement submitBtn;
    @FindBy(name = "submit.deleteItem")
    public WebElement removeBtn;
    @FindBy(xpath = "//span[@data-action='reg-item-delete-undo']")
    public WebElement undoBtn;
    @FindBy(id = "profile-list-name")
    public WebElement profileListName;

    public void clickCreateAListBtn() {
        clickElement(createAListBtn);
    }

    public void clearListName() {
        clearElement(listNameInput);
    }

    public void typeListName(String listName) {
        sendKeysElement(listNameInput, listName);
    }

    public void clickSubmitBtn(){
        clickElement(submitBtn);
    }

    public void removeItemFromList() {
        clickElement(removeBtn);
    }

    public void isTheListPageOpened(String listName) {
        Assert.assertEquals(listName, getText(profileListName));
    }

    public void isItemRemovedFromList() {
        Assert.assertTrue(isDisplayed(undoBtn));
    }

    public void clickListName(String listName) {
        By list = By.xpath("//span[contains(@id,'wl-list-entry-title') and contains(text(),'" + listName + "')]");
        clickElement(list);
    }
}
