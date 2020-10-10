package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class SignInPage extends TestBase {
	//define driver
	public WebDriver driver;

	//constructor
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators

	@FindBy(xpath="//a[@title='Log in to your customer account']")
	WebElement SignInButton;

	@FindBy(id="email")
	WebElement txt_Email;

	@FindBy(id="passwd")
	WebElement txt_password;

	@FindBy(id="SubmitLogin")
	WebElement ClickOnSubmit;

	//Action method
	public void ClickOnSignInBtn() {
		SignInButton.click();

	}
	public void SetEmailName(String uname) throws Exception {
		txt_Email.clear();
		txt_Email.sendKeys(uname);
		Thread.sleep(2000);	
		}

	public void SetPassword(String pwd) {
		txt_password.clear();
		txt_password.sendKeys(pwd);
	}
	public void ClickOnSubmitButton() throws Exception {
		ClickOnSubmit.click();
		Thread.sleep(4000);
		}
	
	public void ValidPageTitle(String title) {
		driver.getTitle();
	}


}





















