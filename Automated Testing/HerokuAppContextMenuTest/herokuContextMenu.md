# Heroku App - Context Menu test


Context menu items are custom additions that appear in the right-click menu. Point of this exercise was to automate the right-click in the box. After click it, it would trigger a JavaScript alert. Here are the steps:

Scenario: checking the context menu functionality
>- Given user is on a herokuapp page
>- When user clicks "context menu" form the list
>- And user is on "context menu" page
>- And user rightclicks the box to trigger a JavaScript alert
>- Then user can see an alert

  
 So, first I launched IntelliJ IDEA and started a new Maven project. After loading Junit, Selenium and Cucumber as dependencies to my `pom.xml` I created three files: `TestRunner, ContextMenu.feature` and `ContextMenuSteps`. Then I set up all those files with code.
 
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
        tags = {"@contextMenuTest"}
)
public class TestRunner {
}
```
#### ContextMenuLogin.feature

```
Feature: Context Menu functionality
  Context menu items are custom additions that appear in the right-click menu.
  Right-click in the box to trigger a JavaScript alert.

  @contextMenuTest
  Scenario: checking the context menu functionality
    Given user is on a herokuapp page
    When user clicks "context menu" form the list
    And user is on "context menu" page
    And user rightclicks the box to trigger a JavaScript alert
    Then user can see an alert
```

#### HerokuSteps

```
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

    @And("^user rightclicks the box to trigger a JavaScript alert$")
    public void user_rightclicks_the_box_to_trigger_a_javascript_alert() {
//      Right click the box
        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();
    }

}
```


So this the result I got:



![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Automated%20Testing/HerokuAppContextMenuTest/images/contextMessage.png)
