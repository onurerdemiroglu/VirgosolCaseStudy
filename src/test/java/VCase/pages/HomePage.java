package VCase.pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "nav-logo-sprites")
    public WebElement amazonLogo;
    @FindBy(id = "sp-cc-accept")
    public WebElement acceptCookiesBtn;
    @FindBy(id = "nav-link-accountList")
    public WebElement accountList;
    @FindBy(xpath = "//a[@data-nav-ref='nav_signin']")
    public WebElement signInBtn;
    @FindBy(id = "nav-item-signout")
    public WebElement signOutBtn;
    @FindBy(xpath = "(//div[@id='nav-al-wishlist']/a)[1]")
    public WebElement createListBtn;
    @FindBy(className = "nav-panel")
    public WebElement navPanel;
    @FindBy(id = "nav-search-label-id")
    public WebElement searchCategory;
    @FindBy(id = "nav-search-dropdown-card")
    public WebElement searchDropDownBox;
    @FindBy(id = "searchDropdownBox")
    public WebElement categoryDropDownItem;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitBtn;

    public void isHomePageOpened() {
        Assert.assertTrue(amazonLogo.isDisplayed());
    }

    public void clickAcceptCookiesBtn() {
        clickElement(acceptCookiesBtn);
    }

    public void hoverAccountList() {
        hoverElement(accountList);
    }

    public void clickSignInBtn() {
        clickElement(signInBtn);
    }
    public void clickSignOutBtn() {
        clickElement(signOutBtn);
    }

    public void clickCreateListBtn() {
        clickElement(createListBtn);
    }

    public void isSignOutBtnDisplayed() {
        Assert.assertTrue(isDisplayed(signOutBtn));
    }

    public void clickSearchDropDown() {
        stalenessOfElementClick(searchDropDownBox);
    }

    public void chooseSearchCategory(String category) {
        selectDropDown(categoryDropDownItem, category);
    }

    public void isSearchCategorySelected(String category) {
        Assert.assertEquals(category, getText(searchCategory));
    }

    public void typeSearchTextBox(String searchKeyword) {
        sendKeysElement(searchTextBox, searchKeyword);
    }

    public void clickSearchSubmitBtn() {
        clickElement(searchSubmitBtn);
    }

    public boolean isThereCreatedList() {
        return elementIsExists(navPanel);
    }

    public void clickAccountTabListName(String listName) {
        By accountListName = By.xpath("//div[@id='nav-al-wishlist']//span[text()='" + listName + "']");
        clickElement(accountListName);
    }
}
