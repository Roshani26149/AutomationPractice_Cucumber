package Pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.TestBase;



public class ProductListPage extends TestBase{
	public 	WebDriver driver;
	TestBase testbase;

	public ProductListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators

	@FindBy(xpath="//input[@class='search_query form-control ac_input']")
	WebElement Search_Product;

	@FindBy(name="submit_search")
	WebElement Search_btn;

	@FindBy(xpath="//label[@for='selectProductSort']")
	WebElement sort_dropdown;

	@FindBy(xpath="//i[@class='icon-th-large']")
	WebElement Grid_icon;

	@FindBy(xpath="//a[@title='View a top sellers products']")
	WebElement TopSeller_link;

	@FindBy(xpath="//a[@class='quick-view']")
	WebElement ClickonFadedShortSleeveTshirts;

	//Actions
	public void SearchProduct () {
		Search_Product.sendKeys("T-Shirts");
	}
	public void ClickOnSearchBtn() {
		Search_btn.click();
	}
	public boolean ValidSortButton() {
		boolean b= sort_dropdown.isDisplayed();
		return b;
	}
	public void ValidGridIcon() {
		Grid_icon.isDisplayed();


	}
	public void TopSellerLinkDisplay() {
		TopSeller_link.isDisplayed();
	}
	public void ClickonFadedShortSleeveTshirtsProduct(String category) {
   }
}

