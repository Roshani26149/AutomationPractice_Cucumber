package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingSucessfulPage {
	WebDriver driver;
	
	public ShoppingSucessfulPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2//i[@class='icon-ok']")
	WebElement sucessfullValidation;
	
	@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	WebElement checkout;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement ContinueShoppingBtn;
	
	
	public void DisplayContinueShoppingBtn() {
		ContinueShoppingBtn.isDisplayed();
	}
	public void valideMassage(String title) {
		sucessfullValidation.getText();
	}
	
	public void validCheakOut() {
		checkout.click();
	}

}
