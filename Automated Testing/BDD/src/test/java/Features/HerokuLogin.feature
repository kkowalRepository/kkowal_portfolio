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
