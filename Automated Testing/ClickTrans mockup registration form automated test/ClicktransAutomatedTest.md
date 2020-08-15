# ClickTrans Registration Form Automated Test

The goal for this task was to provide automated testing of registration form https://dev-1.clicktrans.pl/register-test/courier. For this I chose two scenarios: correct and incorrect way to register into the system.

So, first I launched IntelliJ IDEA and started a new Maven project. After loading Junit, Selenium and Cucumber as dependencies to my `pom.xml` I created four files: `TestRunner_correct, TestRunner_incorrect, Registration.feature` and `RegistrationSteps`. Then I set up all those files with code.

#### TestRunner_correct

```
ppackage CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions",
        tags = {"@correctRegistration"}
)

public class TestRunner {
}
```

#### TestRunner_incorrect

```
ppackage CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions",
        tags = {"@incorrectRegistration"}
)

public class TestRunner {
}
```

#### Registration.feature

```
Feature: mockup registration form test

  @correctRegistration
  Scenario: correct registration
    Given User launches browser
    And User enters a given website "https://dev-1.clicktrans.pl/register-test/courier"
    When User enters correct PelnaNazwaFirmy
    When User enters correct Email
    When  User enters correct ImieINazwisko
    When  User enters correct Telefon
    When  User enters correct Haslo
    When User checks checkbox no1
    When user checks checkbox no2
    When user checks checkbox no3
    When  User clicks Zarejestruj
    Then User is registered

  @incorrectRegistration
  Scenario: incorrect registration
    Given User launches browser
    And User enters a given website "https://dev-1.clicktrans.pl/register-test/courier"
    When User enters correct PelnaNazwaFirmy
    When User enters incorrect Email
    When  User enters correct ImieINazwisko
    When  User enters correct Telefon
    When  User enters correct Haslo
    When User checks checkbox no1
    When user checks checkbox no2
    When user checks checkbox no3
    When  User clicks Zarejestruj
    Then User is not registered
```

#### RegistrationSteps

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

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class RegistrationSteps {

    WebDriver driver;

    @Given("^User launches browser$")
    public void user_launches_browser()  {
        System.setProperty("webdriver.chrome.driver", "/Users/konradkowal/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window();
        driver.manage().deleteAllCookies();
        System.out.println("User launched a Chrome browser");

    }

    @Given("^User enters a given website \"([^\"]*)\"$")
    public void user_enters_a_given_website(String arg1)  {
        driver.get("https://dev-1.clicktrans.pl/register-test/courier");
        Assert.assertEquals("https://dev-1.clicktrans.pl/register-test/courier", driver.getCurrentUrl());
        System.out.println("User entered a given login website");

    }

    @When("^User enters correct PelnaNazwaFirmy$")
    public void user_enters_correct_PelnaNazwaFirmy()  {
        WebElement inputCompanyName = driver.findElement(By.id("user_register_company_name"));
        inputCompanyName.sendKeys("Test Company Name");
        System.out.println("User entered valid company name");
    }

    @Then("^User is registered$")
    public void user_is_registered()  {
        WebElement textSuccess = driver.findElement(By.xpath("/html/body/div[6]/div"));
        Assert.assertEquals("OK - some registration logic is mocked", textSuccess.getText());
        System.out.println("User is registered");
    }

    @Then("^User is not registered$")
    public void user_is_not_registered() {
        WebElement textFail = driver.findElement(By.xpath("/html/body/div[6]/div"));
        Assert.assertEquals("Error", textFail.getText());
        System.out.println("User is not registered");
    }


    @When("^User enters correct Email$")
    public void user_enters_correct_Email()  {
        WebElement inputEmail = driver
                .findElement(By.xpath("//*[@id=\"user_register_email\"]"));
        inputEmail.sendKeys("test@wp.pl");
        System.out.println("User entered valid email address");
    }

    @When("^User enters incorrect Email$")
    public void user_enters_incorrect_Email()  {
        WebElement inputBadEmail = driver
                .findElement(By.xpath("//*[@id=\"user_register_email\"]"));
        inputBadEmail.sendKeys("testwp.pl");
        System.out.println("User entered valid email address");

    }

    @When("^User enters correct ImieINazwisko$")
    public void user_enters_correct_ImieINazwisko() {
        WebElement inputName = driver
                .findElement(By.xpath("//*[@id=\"user_register_name\"]"));
        inputName.sendKeys("Test Name");
        System.out.println("User entered valid name");
    }

    @When("^User enters correct Telefon$")
    public void user_enters_correct_Telefon()  {
        WebElement inputPhoneNo = driver
                .findElement(By.xpath("//*[@id=\"user_register_phone\"]"));
        inputPhoneNo.sendKeys("123123123");
        System.out.println("User entered valid phone number");
    }

    @When("^User enters correct Haslo$")
    public void user_enters_correct_Haslo()  {
        WebElement inputPassword = driver
                .findElement(By.xpath("//*[@id=\"user_register_plainPassword\"]"));
        inputPassword.sendKeys("TestPass123");
        System.out.println("User entered valid password");
    }
    @When("^User checks checkbox no1$")
    public void user_checks_checkbox_no1()  {
        WebElement checkboxOne = driver.findElement(By.xpath("//*[@id=\"user_register_settings_agreementRegulations\"]"));
        checkboxOne.click();
        System.out.println("User checked checkbox no.1");
    }

    @When("^user checks checkbox no2$")
    public void user_checks_checkbox_no2()  {
        WebElement checkboxTwo = driver.findElement(By.xpath("//*[@id=\"user_register_settings_agreementPersonalData\"]"));
        checkboxTwo.click();
        System.out.println("User checked checkbox no.2");
    }

    @When("^user checks checkbox no3$")
    public void user_checks_checkbox_no3()  {
        WebElement checkboxThree = driver.findElement(By.xpath("//*[@id=\"user_register_settings_agreementMarketing\"]"));
        checkboxThree.click();
        System.out.println("User checked checkbox no.3");
    }


    @When("^User clicks Zarejestruj$")
    public void user_clicks_Zarejestruj()  {
        WebElement register = driver
                .findElement(By.xpath("//*[@id=\"user_register_submit\"]"));
        register.click();
        System.out.println("User clicked Zarejestruj button");
    }

}

```

Another imprtant part was to check that form was sent correctly with an assert on the message “OK - some registration logic is mocked”. To acheive that I performed an assertion:

Correct registration

```
public void user_is_registered()  {
        WebElement textSuccess = driver.findElement(By.xpath("/html/body/div[6]/div"));
        Assert.assertEquals("OK - some registration logic is mocked", textSuccess.getText());
        System.out.println("User is registered");
    }
```
Incorrect registration

```
public void user_is_not_registered() {
        WebElement textFail = driver.findElement(By.xpath("/html/body/div[6]/div"));
        Assert.assertEquals("Error", textFail.getText());
        System.out.println("User is not registered");
    }
```

So this the result I got for the Scenario 1:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/ClickTrans%20mockup%20registration%20form%20automated%20test/testResults/testCorrect.png)

and for the Scenario 2:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/ClickTrans%20mockup%20registration%20form%20automated%20test/testResults/testIncorrect.png)




