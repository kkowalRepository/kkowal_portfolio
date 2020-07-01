# BDD - Automation Practice


This is a BDD (Behaviour Driven Development) automated test of a website: http://automationpractice.com/index.php. It's purpose is to check existing functionality of logging into customer's account given the account was praviousely set.
Basic steps to check this feature are:
 
>- go to a website : http://automationpractice.com/index.php
>- click “ Sign In”
>- go to login form 
>- enter e-mail address: testes@wp.pl
>- enter password: ttttt
>- validate weather the test was successful( so the user could successfully log in)
>- close the browser
 
 
 So, first I launched IntelliJ IDEA and started a new Maven project. After loading Junit, Selenium and Cucumber as dependencies to my `pom.xml` I created three files: `Login_TestRunner, Login.feature` and `LoginSteps`. Then I set up all those files with code.
 
#### Login_testRunner

```
package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions"
)
public class Login_TestRunner {
}

```
#### Login.feature

```
Feature: Login test

  As a user I want to log into my account at : http://automationpractice.com/index.php
  My email address: testes@wp.pl
  My password: ttttt

  @scenarioOne
  Scenario Outline: login process to http://automationpractice.com/index.php
  
    Given open browser
    And internet connection
    And user goes to the website: "http://automationpractice.com/index.php"
    And user clicks "Sign in" button in the top right corner
    When user types email address <email> in field <loginId> in "Already registered?" form
    And user types password <password> in field <passField> in "Already registered?" form
    And user clicks "Sign in" button
    Then user is registered
    Examples:
      | email                | password        | loginId | passField |
      | testes@wp.pl         | ttttt           | email   | pass      |
```

#### LoginSteps

```
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
    }
```

To validate weather test was successful I used the `if` statement. In case test is successful the console will return `Test passed` else `Test failed`.
    
    
```
    

    @Then("^user is registered$")
    public void user_is_registered()  {

        String pageURL = driver.getCurrentUrl();

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


```
So this the result I got:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/images/APloginTest.png)
