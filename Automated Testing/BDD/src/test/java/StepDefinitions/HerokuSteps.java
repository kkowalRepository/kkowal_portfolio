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

import java.awt.event.MouseEvent;
import java.sql.Driver;

public class HerokuSteps {

WebDriver driver;

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/konradkowal/Documents/GitHub/kkowal_portfolio/Automated Testing/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://the-internet.herokuapp.com/login");
        System.out.println("User is on login page");
    }

    @When("^user inputs the correct login$")
    public void user_inputs_the_correct_login() {
        WebElement inputUsername = driver.findElement(By.id("username"));
        inputUsername.sendKeys("tomsmith");
        System.out.println("user entered correct login");
    }

    @When("^user inputs the incorrect login$")
    public void user_inputs_the_incorrect_login() {
        WebElement inputUsername = driver.findElement(By.id("username"));
        inputUsername.sendKeys("johndoe");
        System.out.println(" user entered incorrect login");
    }

    @And("^user inputs the correct password$")
    public void user_inputs_the_correct_password() {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("SuperSecretPassword!");
        System.out.println("user entered correct password");
    }

    @And("^user inputs the incorrect password$")
    public void user_inputs_the_incorrect_password()  {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("RandomPassword");
        System.out.println("user entered incorrect password");
    }

    @And("^user clicks \"([^\"]*)\" button$")
    public void user_clicks_something_button(String strArg1)  {
        WebElement loginBtn = driver.findElement(By.className("radius"));
        loginBtn.click();
        System.out.println("user clicked the login button");
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() {
        String pageURL = driver.getCurrentUrl();
        if(pageURL.equals("http://the-internet.herokuapp.com/secure")) {
            System.out.println("Correct login test passed");
        }
        else
        {
            System.out.println("Correct login test failed");
        }

    }

    @Then("^user is not logged in$")
    public void user_is_not_logged_in() {
        String pageURL = driver.getCurrentUrl();
        if(pageURL.equals("http://the-internet.herokuapp.com/login")) {
            System.out.println("Incorrect login test passed");
        }
        else
        {
            System.out.println("Incorrect login test failed");
        }
    }

}
