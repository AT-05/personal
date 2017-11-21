Feature: authentication

  Scenario Outline: verification of the new Email
    Given I navigate to MainPage
    When I put the new email
      | newEmail | pedro.pablo5@gmail.com |
    Then should be displayed create page
    Examples:
      | asdas   | asdads   |
      | asdaxxs | asdxxads |

