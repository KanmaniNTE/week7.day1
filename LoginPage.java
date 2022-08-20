package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	public ChromeDriver driver;
	@Given("Open the chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}
	@And("Load the URL and Maximize")
	public void loadURL() {
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

	}
	@Given("Type the user name as {string}")
	public void typeUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);

	}
	@And("Type the password as {string}")
	public void TypePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);

	}
	@When("Click on the Login button")
	public void clickLogin() {
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}
	@Then("Verify the Home page is displayed.")
	public void verifyHomepage() {
		WebElement logout =driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("Value");
		System.out.println(attribute);
		if(attribute.equalsIgnoreCase("Logout")) {
			System.out.println("Successfully logged in");
		}

	}
	@But("Verify the Error message is displayed.")
	public void verifyErrMessage() {
		String text=driver.findElement(By.id("errorDiv")).getText();
		System.out.println(text);

	}




}
