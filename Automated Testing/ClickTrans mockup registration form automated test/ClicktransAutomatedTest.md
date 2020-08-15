# ClickTrans Registration Form Automated Test

The goal for this task was to provide automated testing of registration form https://dev-1.clicktrans.pl/register-test/courier. For this I chose two scenarios: correct and incorrect way to register into the system.

Scenario 1 : @correctRegistration

>- Given User launches browser
>- And User enters a given website "https://dev-1.clicktrans.pl/register-test/courier"
>- When User enters correct PelnaNazwaFirmy
>- When User enters correct Email
>- When  User enters correct ImieINazwisko
>- When  User enters correct Telefon
>- When  User enters correct Haslo
>- When User checks checkbox no1
>- When user checks checkbox no2
>- When user checks checkbox no3
>- When  User clicks Zarejestruj
>- Then User is logged in
    
Scenario 2: @incorrectRegistration

>- Given User launches browser
>- And User enters a given website "https://dev-1.clicktrans.pl/register-test/courier"
>- When User enters correct PelnaNazwaFirmy
>- When User enters incorrect Email
>- When  User enters correct ImieINazwisko
>- When  User enters correct Telefon
>- When  User enters correct Haslo
>- When User checks checkbox no1
>- When user checks checkbox no2
>- When user checks checkbox no3
>- When  User clicks Zarejestruj
>- Then User is not logged in

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





This is what the mockup registration form looks like:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Manual%20Testing/ClickTrans%20mockup%20registration%20form%20test/png/regForm.png)



