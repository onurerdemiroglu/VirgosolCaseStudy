package VCase.step_def;

import VCase.pages.*;
import VCase.utils.Helper;
import VCase.utils.Log4j;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {
    HomePage homePage;
    LoginPage loginPage;
    ListPage listPage;
    SearchPage searchPage;
    ProductPage productPage;
    Helper helper;

    public AmazonSteps() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        listPage = new ListPage();
        searchPage = new SearchPage();
        productPage = new ProductPage();
        helper = new Helper();
    }

    @Given("I visit {string}")
    public void iVisit(String url) {
        helper.navigateToUrl(url);
        Log4j.info(String.format("Navigated to '%s'", url));
    }

    @And("I check that the home page is opened")
    public void iCheckThatTheHomePageIsOpened() {
        homePage.isHomePageOpened();
        Log4j.info("Successfully navigated to the url");
    }

    @And("I choose Accept Cookies from the cookie preferences")
    public void iChooseAcceptCookiesFromTheCookiePreferences() {
        homePage.clickAcceptCookiesBtn();
        Log4j.info("Cookies accepted");
    }

    @And("I login with {string} and {string}")
    public void iLoginWithEmailAndPassword(String email, String password) {
        homePage.hoverAccountList();
        homePage.clickSignInBtn();
        loginPage.typeEmail(email);
        loginPage.clickContinueBtn();
        loginPage.typePassword(password);
        loginPage.clickSignInSubmitBtn();
        Log4j.info("Login successfully completed");
    }

    @And("I check that successfully login")
    public void iCheckThatSuccessfullyLogin() {
        homePage.hoverAccountList();
        homePage.isSignOutBtnDisplayed();
        Log4j.info("Login process is verified");
    }

    @And("I am creating a new list called {string} from the My Account section")
    public void iAmCreatingANewListCalledFromTheMyAccountSection(String listName) {
        homePage.hoverAccountList();
        boolean isThereList = homePage.isThereCreatedList();
        homePage.clickCreateListBtn();

        if (!isThereList) { // eğer daha önce oluşturulmuş liste yoksa
            listPage.clickCreateAListBtn();
        }
        listPage.clearListName();
        listPage.typeListName(listName);
        listPage.clickSubmitBtn();
        Log4j.info("'" + listName + "' named list created");
    }

    @And("I choose {string} from the categories field next to the search button")
    public void iChooseFromTheCategoriesFieldNextToTheSearchButton(String category) {
        homePage.clickSearchDropDown();
        homePage.chooseSearchCategory(category);
        Log4j.info("'" + category + "' is selected from search dropdown");
    }

    @And("I checking that the {string} category is selected")
    public void iCheckingThatTheCategoryIsSelected(String category) {
        homePage.isSearchCategorySelected(category);
        Log4j.info("'" + category + "' selection is verified");
    }

    @And("I type {string} in the search field and click the search button")
    public void iTypeInTheSearchFieldAndClickTheSearchButton(String searchKeyword) {
        homePage.typeSearchTextBox(searchKeyword);
        homePage.clickSearchSubmitBtn();
        Log4j.info("Search was done for '" + searchKeyword + "'");
    }

    @And("I checking that {string} successfully listed")
    public void iCheckingThatSuccessfullyListed(String searchKeyword) {
        searchPage.isSearchKeywordListed(searchKeyword);
        Log4j.info("Verified that the search is listed for the '" + searchKeyword + "'");
    }

    @And("I open the {string} page from the search results page")
    public void iOpenThePageFromTheSearchResultsPage(String pageNumber) {
        searchPage.selectPageFromPagination(pageNumber);
        Log4j.info("Passed into the number '" + pageNumber + "' page");
    }

    @And("I check that page {string} is opened from the search results page")
    public void iCheckThatPageIsOpenedFromTheSearchResultsPage(String pageNumber) {
        searchPage.IsPageSelected(pageNumber);
        Log4j.info("Verified that number '" + pageNumber + "' page is selected");
    }

    @And("I add the {string} product on the page to the created {string} list")
    public void iAddTheProductOnThePageToTheCreatedList(String productNumber, String listName) {
        searchPage.selectProductFromSearchList(productNumber);
        productPage.addProductToList(listName);
        Log4j.info("Number '" + productNumber + "' product has been added to the '" + listName + "'");
    }

    @And("I checking if the product has been added to the list")
    public void iCheckingIfTheProductHasBeenAddedToTheList() {
        productPage.isProductAddedToList();
        productPage.clickContinueShopping();
        Log4j.info("Verified that product has been added to the list");
    }

    @And("I go to the {string} page")
    public void iGoToThePage(String listName) {
        homePage.hoverAccountList();
        homePage.clickAccountTabListName(listName);
        Log4j.info("Navigated to the '" + listName + "' page");
    }

    @And("I check that the {string} page opens")
    public void iCheckThatThePageOpens(String listName) {
        listPage.isTheListPageOpened(listName);
        Log4j.info("Verified that '" + listName + "' page is opened");
    }

    @And("I remove the added product from the {string}")
    public void iRemoveTheAddedProductFromThe(String listName) {
        listPage.clickListName(listName);
        listPage.removeItemFromList();
        Log4j.info("Product removed from the '" + listName + "'");
    }

    @And("I check if the product has been deleted from the list")
    public void iCheckIfTheProductHasBeenDeletedFromTheList() {
        listPage.isItemRemovedFromList();
        Log4j.info("Verified that product removed from the list");
    }

    @When("I logout of account")
    public void iLogoutOfAccount() {
        homePage.hoverAccountList();
        homePage.clickSignOutBtn();
        Log4j.info("Logout process was done");
    }

    @Then("I check that the logout was successful")
    public void iCheckThatTheLogoutWasSuccessful() {
        loginPage.isLogOutSuccessfull();
        Log4j.info("Verified that successfully logout");
    }
}
