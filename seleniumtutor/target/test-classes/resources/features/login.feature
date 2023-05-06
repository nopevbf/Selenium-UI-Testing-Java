@All
  Feature: Login
    As a user
    I want to login
    So that I can access my account

    @Test1
    Scenario: Login with valid credentials
        Given I am on the login page
        When I enter valid credentials
        And I click on the login button
        Then I should be logged in