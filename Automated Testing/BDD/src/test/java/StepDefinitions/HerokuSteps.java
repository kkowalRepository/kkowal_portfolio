package StepDefinitions;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;
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
    public void user_inputs_the_correct_login()  {
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("tomsmith");
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() {
        String pageUrl = driver.getCurrentUrl();
        if(pageUrl.equals("http://the-internet.herokuapp.com/secure")) {
            System.out.println(" user logged in");
        }
        else{
            System.out.println("user didn't log in");
        }
    }

    @And("^user inputs the correct password$")
    public void user_inputs_the_correct_password() {
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("SuperSecretPassword!");
    }

    @And("^user1 clicks \"([^\"]*)\" button$")
    public void user1_clicks_something_button(String strArg1) {
        WebElement loginBtn = driver.findElement(By.className("radius"));
        loginBtn.click();
    }

    @When("^user inputs the incorrect login$")
    public void user_inputs_the_incorrect_login() {
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("someLogin");
    }

    @And("^user inputs the incorrect password$")
    public void user_inputs_the_incorrect_password() {
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("randomPassword");
    }
    @Then("^user is not logged in$")
    public void user_is_not_logged_in() {
        String pageUrl = driver.getCurrentUrl();
        if(pageUrl.equals("http://the-internet.herokuapp.com/secure")){
            System.out.println("test failed, user logged in");
        }
        else
        {
            System.out.println("test passed, user is not logged in");
        }
    }

}
