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

public class LoginSteps {

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
        System.out.println("User entered a given login website");

    }

    @When("^User enters correct PelnaNazwaFirmy$")
    public void user_enters_correct_PelnaNazwaFirmy()  {
        WebElement inputCompanyName = driver.findElement(By.id("user_register_company_name"));
        inputCompanyName.sendKeys("Test Company Name");
        System.out.println("User entered valid company name");
    }

    @Then("^User is logged in$")
    public void user_is_logged_in()  {
        WebElement textSuccess = driver.findElement(By.xpath("/html/body/div[6]/div"));
        String elementText = textSuccess.getText();
        if(elementText.equals("OK - some registration logic is mocked")) {
            System.out.println("User is logged in");
        }
        else {
            System.out.println("User is not logged in");
        }

    }


    @When("^User enters correct Email$")
    public void user_enters_correct_Email()  {
        WebElement inputEmail = driver
                .findElement(By.xpath("//*[@id=\"user_register_email\"]"));
        inputEmail.sendKeys("test@wp.pl");
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
