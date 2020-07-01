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
