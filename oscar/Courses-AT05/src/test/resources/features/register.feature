@Register
Feature: Register

  @Logout
  Scenario: User should be able to create account with valid credentials
    Given I navigate to Login page
    And I navigate to Register page
    When I register with first name, last name, email and password
    Then the Home page should be displayed

#    Examples:
#      | First_name    | Last_name     | Email_user       | Password     |
#      | oscar         | oz            | oscar1@oscar.com | password123  |

  Scenario: User registered be able to subscribe a free COURSE
    Given I navigate to Login page
    When I login with email and password valid
