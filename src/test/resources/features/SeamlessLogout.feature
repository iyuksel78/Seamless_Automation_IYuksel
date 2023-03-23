Feature: Logout functionality of https://qa.seamlessly.net/
  As a registered user
  I want to be able to log out of the application

  Background:
    Given the user is logged successfully

  Scenario: US-002_TC1 User can log out and ends up in login page (IY)
    When user clicks on the avatar image
    And user clicks on the Log out button from dropdown menu
    Then user  goes back to the login page



  Scenario: US-002_TC1 Verify user can not go to home page again by clicking step back button after successfully
  logged out (IY)
    When user successfully logged out
    And user click on step back button
    Then user can not go to home page