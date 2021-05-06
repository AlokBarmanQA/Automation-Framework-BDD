package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import basepackage.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Tutorials_Ninja_Landing_Page_Objects;
import pageObjects.Tutorials_Ninja_Login_Page_Objects;
import tests.Tutorials_Ninja_Login_Page_Test;
import utilities.PropertiesReader;

public class Tutorials_Ninja_Login_Page_Steps extends Base{
	Logger log;
	public WebDriver driver;
	Tutorials_Ninja_Landing_Page_Objects landingPageObjects;
	Tutorials_Ninja_Login_Page_Objects loginPageObjects;

	@Given("Open any browser")
	public void open_any_browser() {
		log = LogManager.getLogger(Tutorials_Ninja_Login_Page_Test.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
	}

	@Given("Navigate to login Page")
	public void navigate_to_login_page() {
		driver.navigate().to(PropertiesReader.getPropertyValueByKey("appURL"));
		log.debug("Navigated to application URL");
	}

	@When("user login using username as {string} and password as {string}")
	public void user_login_using_username_as_and_password_as(String email, String password) {
		landingPageObjects = new Tutorials_Ninja_Landing_Page_Objects(driver);
		loginPageObjects = new Tutorials_Ninja_Login_Page_Objects(driver);

		landingPageObjects.clickOnMyAccountDD();
		log.debug("Clicked on My Account dropdown");
		landingPageObjects.clickOnLogin();
		log.debug("Clicked on login button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		try {
			loginPageObjects.loginToApplication(email, password);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("Verify user is able to successful login")
	public void verify_user_is_able_to_successful_login() {
		loginPageObjects = new Tutorials_Ninja_Login_Page_Objects(driver);
		Assert.assertTrue(loginPageObjects.verifyMyAccount().isDisplayed());
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
}
