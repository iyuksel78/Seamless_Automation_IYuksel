@SEAMLES10-499
Feature: Login functionality of https://qa.seamlessly.net/

  Background:
		#@SEAMLES10-491
    Given user is on the "login page"

  @SEAMLES10-490
  Scenario: US1_TC1 Verify that user can login with valid credentials(IY)
    When user enters a valid "username" and "password"
    And user clicks on the Login button or hit the Enter key
    Then user verifies the Dashboard page


  @SEAMLES10-493
  Scenario: US1_TC2 Verify that user can not login with any invalid credentials(IY)
    When user enters invalid "username" or invalid "password"
    And user clicks on the Login button or hit the Enter key
    Then user verifies warning message "Wrong username or password."


  @SEAMLES10-494
  Scenario: US1_TC3 Verify that user can not login with any blank credentials(IY)
    When user leaves "username" or "password" field empty
    And user clicks on the Login button or hit the Enter key
    Then user verifies warning message "Please fill out this field."


  @SEAMLES10-495
  Scenario: US1_TC4 Verify that user can see the password in a form of dots by default(IY)
    When user enters the password
    Then user verifies the password in form of dots


  @SEAMLES10-496
  Scenario: US1_TC5 Verify that user can see the password explicitly(IY)
    When user clicks on toggle button
    Then user verifies the password in plain text


  @SEAMLES10-497
  Scenario: US1_TC6 Verify that user can see the "Forgot password?" link on the login page(IY)
    When user clicks on the Forgot Password? link
    Then user verifies Reset Password button is visible


  @SEAMLES10-498
  Scenario: US1_TC7 Verify that user can see valid placeholders on Username and Password fields(IY)
    When user clicks on username and password input-boxes
    Then user verifies valid placeholder for username and Password