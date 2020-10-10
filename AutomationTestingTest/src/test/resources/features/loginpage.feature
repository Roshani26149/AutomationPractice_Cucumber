Feature: To automate the AutomationTesting URL

  Scenario: Sucessful login with valid credential
    Given User launch the chrome browser and open the URL "http://automationpractice.com/index.php"
    When User Click on Sign In button
    And User enter email as "jetblue@grr.la" and passwprd as "jetblue"
    And Click on login
    Then Page Title should be "My account - My Store"
    When User search the T-shirts product
    And Click on product Faded Short Sleeve T-shirts
    And Click on Add to Cart and proceed to checkout button
    Then Message should be displayed as "Product successfully added to your shopping cart"
    And Close the browser
