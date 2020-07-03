package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver;

    @Given("^open browser$")
    public void open_browser() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/konradkowal/Documents/GitHub/kkowal_portfolio/Automated Testing/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

    }

    @Given("^internet connection$")
    public void internet_connection()  {
    }

    @Given("^user goes to the website: \"([^\"]*)\"$")
    public void user_goes_to_the_website(String arg1) {
        driver.get("http://automationpractice.com/index.php");
        driver.getCurrentUrl();

    }

    @And("^user clicks \"([^\"]*)\" button in the top right corner$")
    public void user_clicks_button_in_the_top_right_corner(String arg1) throws InterruptedException {
        WebElement signIn = driver.findElement(By.className("login"));
        signIn.click();
        Thread.sleep(1000);
    }

    @When("^user types email address testes@wp\\.pl in field email in \"([^\"]*)\" form$")
    public void user_types_email_address_testes_wp_pl_in_field_email_in_form(String arg1) {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("testes@wp.pl");
    }

    @When("^user types password ttttt in field pass in \"([^\"]*)\" form$")
    public void user_types_password_ttttt_in_field_pass_in_form(String arg1)  {
        WebElement passInput = driver.findElement(By.id("passwd"));
        passInput.sendKeys("ttttt");
    }

    @When("^user clicks \"([^\"]*)\" button$")
    public void user_clicks_button(String arg1) throws InterruptedException {
        WebElement signInBtn = driver.findElement(By.id("SubmitLogin"));
        signInBtn.click();
        Thread.sleep(1000);
    }

    @Then("^user is registered$")
    public void user_is_registered()  {

        String pageURL = driver.getCurrentUrl();

// Validate Current Page URL
        if(pageURL.equals("http://automationpractice.com/index.php?controller=my-account"))
        {
            System.out.println("Test Passed.");
        }
        else
        {
            System.out.println("Test 3 Failed.");
        }
        driver.quit();
    }


}

