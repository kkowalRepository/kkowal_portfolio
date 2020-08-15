Feature: mockup registration form test

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
    Then User is logged in