package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver;

    @Given("^open browser$")
    public void open_browser() {
    }

    @Given("^internet connection$")
    public void internet_connection()  {
    }

    @Given("^user goes to the website: \"([^\"]*)\"$")
    public void user_goes_to_the_website(String arg1) {
    }

    @Given("^user clicks \"([^\"]*)\" button in the top right corner$")
    public void user_clicks_button_in_the_top_right_corner(String arg1){
    }

    @When("^user types email address test@poczta\\.onet\\.pl in field email in \"([^\"]*)\" form$")
    public void user_types_email_address_test_poczta_onet_pl_in_field_email_in_form(String arg1)  {
    }

    @When("^user types password Tester(\\d+) in field pass in \"([^\"]*)\" form$")
    public void user_types_password_Tester_in_field_pass_in_form(int arg1, String arg2) {
    }

    @When("^uzytkownik w pole <poleHaslo> wpisuje wartosc Tester(\\d+)$")
    public void uzytkownik_w_pole_poleHaslo_wpisuje_wartosc_Tester(int arg1) {
    }

    @When("^uzytkownik klika przycisk \"([^\"]*)\"$")
    public void uzytkownik_klika_przycisk(String arg1)  {
    }

    @Then("^uzytkownik poprawnie loguje sie do systemu$")
    public void uzytkownik_poprawnie_loguje_sie_do_systemu() {
    }




//    WebDriver driver;
//
//    @Given("^open browser$")
//    public void open_browser()

//    @When("^user types email address (.+) in field (.+) in \"([^\"]*)\" form$")
//    public void user_types_email_address_in_field_in_something_form(String email, String fieldid, String strArg1);
//
//    }
//
//    @Then("^uzytkownik poprawnie loguje sie do systemu$")
//    public void uzytkownik_poprawnie_loguje_sie_do_systemu() throws Throwable {
//        throw new PendingException();
//    }
//
//    @And("^internet connection$")
//    public void internet_connection() throws Throwable {
//        throw new PendingException();
//    }
//
//    @And("^user goes to the website: \"([^\"]*)\"$")
//    public void user_goes_to_the_website_something(String strArg1) throws Throwable {
//        throw new PendingException();
//    }
//
//    @And("^user clicks \"([^\"]*)\" button in the top right corner$")
//    public void user_clicks_something_button_in_the_top_right_corner(String strArg1) throws Throwable {
//        throw new PendingException();
//    }
//
//    @And("^user types password (.+) in field (.+) in \"([^\"]*)\" form$")
//    public void user_types_password_in_field_in_something_form(String password, String passfield, String strArg1) throws Throwable {
//        throw new PendingException();
//    }
//
//    @And("^uzytkownik w pole (.+) wpisuje wartosc (.+)$")
//    public void uzytkownik_w_pole_wpisuje_wartosc(String polehaslo, String password) throws Throwable {
//        throw new PendingException();
//    }
//
//    @And("^uzytkownik klika przycisk \"([^\"]*)\"$")
//    public void uzytkownik_klika_przycisk_something(String strArg1) throws Throwable {
//        throw new PendingException();
//    }
//
//}


}
