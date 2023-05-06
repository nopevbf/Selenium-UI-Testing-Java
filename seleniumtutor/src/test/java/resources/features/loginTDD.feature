Feature: Login with TDD

  @TDD @Login
    Scenario Outline: Login with valid credentials
        Given I am on the login page
        When I enter valid <username> and <password>
        And I click on the login button
        Then I get verify login <result>

    Examples:
        | username | password | result |
        | standard_user    | secret_sauce    | pass   |
        | invalidUsername    | secret_sauce   | fail   |
        | standard_user   | invalidPassword    | fail   |
