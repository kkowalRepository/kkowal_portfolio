# Heroku App - Login functionality test


http://the-internet.herokuapp.com is a test automastion practice website with many examples to explore. For this task I chose the login page test. This is where user can acces secure area aftre logging in. I created two scenarios for coccrect and incorrect entries. So the basic steps to get there are:

Scenario one: @correctDataHeroku 
>- go to a website : http://http://the-internet.herokuapp.com/login
>- enter correct username: tomsmith
>- enter correct password: SuperSecretPassword!
>- clikc login
>- user is logged into a secure area
>- validate weather the test was successful( so the user could successfully log in)
>- close the browser

Scenario two:  @incorrectDataHeroku
>- go to a website : http://http://the-internet.herokuapp.com/login
>- enter incorrect username: someLogin
>- enter incorrect password: randomPassword
>- clikc login
>- user is not logged into a secure area
>- validate weather the test was successful( so the user could successfully log in)
>- close the browser

  
 So, first I launched IntelliJ IDEA and started a new Maven project. After loading Junit, Selenium and Cucumber as dependencies to my `pom.xml` I created three files: `TestRunner, HerokuLogin.feature` and `HerokuSteps`. Then I set up all those files with code.
 
#### TestRunner

```
package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions",
        tags = {"@incorrectDataHeroku"}
)
public class TestRunner {
}

```
#### HerokuLogin.feature

```
Feature: Login Page test
  As a user I want to check weather I can log into http://the-internet.herokuapp.com/login
  website with a given login and password.
  Login: tomsmith
  Password: SuperSecretPassword!

  @correctDataHeroku
  Scenario: successful login
    Given user is on login page
    When user inputs the correct login
    And user inputs the correct password
    And user1 clicks "Login" button
    Then user is logged in


  @incorrectDataHeroku
  Scenario: unsuccessful login
    Given user is on login page
    When user inputs the incorrect login
    And user inputs the incorrect password
    And user1 clicks "Login" button
    Then user is not logged in
```

#### HerokuSteps

```
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
```

To validate weather test was successful I used the `if` statement. In case of successful scenario one the console will return `user logged in`. In case of successful scenario two the console will return `test passed, user is not logged in`.
    
    
```
Scenario two:  @incorrectDataHeroku     
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
    
Scenario one: @correctDataHeroku   
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

```
So this the result I got:

Scenario one:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/HerokuAppLoginTest/images/scenario1.png)

Scenario two:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/HerokuAppLoginTest/images/scenario2.png)
