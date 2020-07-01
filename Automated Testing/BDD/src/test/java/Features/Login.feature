Feature: Login test

  As a user I want to check if it's possible to login
  to an account at : http://automationpractice.com/index.php
  without registering first.


  @scenarioOne
  Scenario Outline: login process to http://automationpractice.com/index.php
    Given open browser
    And internet connection
    And user goes to the website: "http://automationpractice.com/index.php"
    And user clicks "Sign in" button in the top right corner
    When user types email address <email> in field <fieldId> in "Already registered?" form
    And user types password <password> in field <passField> in "Already registered?" form
    And uzytkownik w pole <poleHaslo> wpisuje wartosc <password>
    And uzytkownik klika przycisk "login"
    Then uzytkownik poprawnie loguje sie do systemu
    Examples:
      | email                | password        | fieldId | passField |
      | test@poczta.onet.pl  | Tester123       | email   | pass      |
