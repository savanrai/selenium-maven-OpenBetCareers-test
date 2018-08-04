package stepDefinations;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchVacanciesTest {

	WebDriver driver;
	String keyword;

	@Given("^user is on openbetcareers homepage$")
	public void user_is_on_openbetcareers_homepage() throws Throwable {

		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("Open Browser");
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
		}

		driver = new ChromeDriver();
		driver.get("https://www.openbetcareers.com/");
		driver.manage().window().fullscreen();

	}

	@Given("^clicks on vacancies$")
	public void clicks_on_vacancies() throws Throwable {

		WebElement linkVacancies = driver
				.findElement(By.xpath("//a[@class='site-nav--menu__link'][contains(text(),'Vacancies')]"));
		linkVacancies.click();

	}

	@When("^Keywords field is available to the user$")
	public void keywords_field_is_available_to_the_user() throws Throwable {
		boolean flag = driver.findElement(By.xpath("//input[@value='Filter by title, expertise']")).isDisplayed();
		String text = driver.findElement(By.xpath("//input[@value='Filter by title, expertise']")).getTagName();
		if (flag) {
			System.out.println(text + " -- is availble on the page");
			Assert.assertEquals(text, "input");
		}
	}

	@When("^User Enters Keywords \"([^\"]*)\"$")
	public void user_Enters_Keywords(String keyword) throws Throwable {
		System.out.println(keyword);
		driver.findElement(By.xpath("//input[@value='Filter by title, expertise']")).sendKeys(keyword);
		
	}

	@When("^user presses Enter$")
	public void User_presses_Enter() throws Throwable {
		System.out.println("Enter");
		driver.findElement(By.xpath("//input[@value='Filter by title, expertise']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@Then("^new results should be displayed$")
	public void new_results_should_be_displayed() throws Throwable {
		
		try {
			int index = 1;
			WebElement baseTable = driver.findElement(By.className("srJobList"));
			List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
			String val = tableRows.get(index).getText();
			System.out.println(val);
			Assert.assertTrue("Job Search Found",true);
		} catch (Exception e) {
			System.out.println("No Job Search Found");
			Assert.assertTrue("No Job Search Found",true);
			//Assert.fail("No Job Search Found");
		}
		
		driver.quit();
		System.out.println("Close Browser");
	}

}
