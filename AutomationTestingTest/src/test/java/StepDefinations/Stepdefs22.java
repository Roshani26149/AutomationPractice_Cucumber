package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import BaseClass.TestBase;
import Pages.ProductListPage;
import Pages.ShoppingSucessfulPage;
import Pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class Stepdefs22 {
	public WebDriver driver;
	String base_url="http://automationpractice.com/index.php?";
	int implicite_time =20;
	Scenario scn;
	

	SignInPage signin;
	ProductListPage productList;
	ShoppingSucessfulPage shoopingsucess;

	@Before
	public void Setup(Scenario scn) throws Exception {
		this.scn=scn;

		String browserName =TestBase.getBrowserName();
		driver=TestBase.getWebDriverForBrowser(browserName);
		signin=new SignInPage(driver);
		productList=new ProductListPage(driver);
		shoopingsucess=new ShoppingSucessfulPage(driver);


	}
	@After
	public void cleanUp() {
		TestBase.quitdriver();
	}


	@Given("User launch the chrome browser and open the URL {string}")
	public void user_launch_the_chrome_browser_and_open_the_url(String base_url) {
		TestBase.navigateToTheUrl(base_url);
		scn.log("browser navigate to url "+base_url);
		String actual=driver.getTitle();
		String expected ="My Store";
		Assert.assertEquals("title is matched in Home page", expected, actual);
		scn.log("Title Of HomePage Matched i.e.--->"+actual);
	}


	@When("User Click on Sign In button")
	public void user_click_on_sign_in_button() {
		signin.ClickOnSignInBtn();
		String actualtitle=driver.getTitle();
		String expectedtite ="Login - My Store";
		Assert.assertEquals("title match in signin page", actualtitle, expectedtite);
      scn.log("Sign is page is successfully displayed with title-->"+actualtitle);
	}

	@And("User enter email as {string} and passwprd as {string}")
	public void user_enter_email_as_and_passwprd_as(String uname, String pwd) throws Exception {
		signin.SetEmailName(uname);
		signin.SetPassword(pwd);
		}

	@And("Click on login")
	public void click_on_login() throws Exception {
		signin.ClickOnSubmitButton();
		scn.log("login sucessfull");


	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		signin.ValidPageTitle(title);
		scn.log("login page title is--->"+driver.getTitle());

	}

	@When("User search the T-shirts product")
	public void user_search_the_t_shirts_product() throws Exception {
		productList.SearchProduct();
		Thread.sleep(3000);
		productList.ClickOnSearchBtn();


	}

	@When("Click on product Faded Short Sleeve T-shirts")
	public void click_on_product_faded_short_sleeve_t_shirts() throws Exception {
		productList.ValidGridIcon();
		productList.ValidSortButton();
		productList.TopSellerLinkDisplay();

		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='product-container']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
		Thread.sleep(1000);
		scn.log("list of tshirt displayed and clicked on Faded Short Sleeve T-shirts");
	}


	@When("Click on Add to Cart and proceed to checkout button")
	public void click_on_add_to_cart_and_proceed_to_checkout_button() {
		shoopingsucess.DisplayContinueShoppingBtn();
		scn.log("sucessfully clicked on add to card button");
	}

	@Then("Message should be displayed as {string}")
	public void message_should_be_displayed_as(String title) {
		shoopingsucess.validCheakOut();
		shoopingsucess.valideMassage(title);
		scn.log("After clicking on add to card msg is--->"+driver.getTitle());


	}

	@Then("Close the browser")
	public void close_the_browser() {
    scn.log("browser closed sucessfully");
     

	}


}
