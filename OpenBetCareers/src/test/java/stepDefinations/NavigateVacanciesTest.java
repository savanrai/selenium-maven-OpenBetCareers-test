package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NavigateVacanciesTest {

	WebDriver driver;
	
	@Given("^user is  on openbetcareers homepage$")
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

	@Given("^menu text is Vacancies$")
	public void menu_text_is_Vacancies() throws Throwable {
		WebElement linkVacancies = driver
				.findElement(By.xpath("//a[@class='site-nav--menu__link'][contains(text(),'Vacancies')]"));

		Assert.assertEquals(linkVacancies.getText(), "Vacancies");
		System.out.println("Expected Link Text: Vacancies");
		System.out.println("Actual Link Text: " + linkVacancies.getText());


	}

	@When("^user clicks on open vacancies$")
	public void user_clicks_on_open_vacancies() throws Throwable {
		WebElement linkVacancies = driver
				.findElement(By.xpath("//a[@class='site-nav--menu__link'][contains(text(),'Vacancies')]"));

		linkVacancies.click();
	}

	@Then("^he should be navigated into the open vacancies area$")
	public void he_should_be_navigated_into_the_open_vacancies_area() throws Throwable {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.openbetcareers.com/#vacancies");

		WebElement textVacancies = driver
				.findElement(By.xpath("//h1[@class='product__header product__header--white']"));
		Assert.assertEquals(textVacancies.getText(), "Vacancies");
		System.out.println("Expected Text: Vacancies");
		System.out.println("Actual Text: " + textVacancies.getText());
		
	}
	
	@And("^close the openbetcareers page$")
	public void close_the_openbetcareers_page() throws Throwable {
		driver.quit();
		System.out.println("Close Browser");
	}

}
