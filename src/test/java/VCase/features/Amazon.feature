Feature: Amazon UI Test

  @positive
  Scenario Outline: Virgosol Case Study
    Given I visit "https://www.amazon.com.tr/"
    And   I check that the home page is opened
    And   I choose Accept Cookies from the cookie preferences
    And   I login with "<email>" and "<password>"
    And   I check that successfully login
    And   I am creating a new list called "<listName>" from the My Account section
    And   I choose "<category>" from the categories field next to the search button
    And   I checking that the "<category>" category is selected
    And   I type "<searchKeyword>" in the search field and click the search button
    And   I checking that "<searchKeyword>" successfully listed
    And   I open the "<pageNumber>" page from the search results page
    And   I check that page "<pageNumber>" is opened from the search results page
    And   I add the "<productNumber>" product on the page to the created "<listName>" list
    And   I checking if the product has been added to the list
    And   I go to the "<listName>" page
    And   I check that the "<listName>" page opens
    And   I remove the added product from the "<listName>"
    And   I check if the product has been deleted from the list
    When  I logout of account
    Then  I check that the logout was successful

    Examples:
      | email                         | password    | listName      | category      | searchKeyword | pageNumber | productNumber |
      | virgosolcasestudy@outlook.com | virgosol123 | Virgosol List | Bilgisayarlar | msi           | 2          | 2             |