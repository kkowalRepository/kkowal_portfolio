package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuSteps {

    WebDriver driver;

    @Given("^user is on a herokuapp page$")
    public void user_is_on_a_herokuapp_page() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/konradkowal/Documents/GitHub/kkowal_portfolio/Automated Testing/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://the-internet.herokuapp.com");
    }

    @When("^user clicks \"([^\"]*)\" form the list$")
    public void user_clicks_something_form_the_list(String strArg1) {
        WebElement contextLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a"));
        contextLink.click();
    }

    @Then("^user can see an alert$")
    public void user_can_see_an_alert() {

    }

    @And("^user is on \"([^\"]*)\" page$")
    public void user_is_on_something_page(String strArg1) {
    }

    @And("^user rightclicks the box to trigger a JavaScript alert$")
    public void user_rightclicks_the_box_to_trigger_a_javascript_alert() {
//      Right click the box
        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();
    }


}
