Feature: Navigate to the open section
  Verify if user is able to navigate into the open vacancies area

  Scenario: Navigate to the open Vacancies section
    Given user is  on openbetcareers homepage
    And menu text is Vacancies
    When user clicks on open vacancies
    Then he should be navigated into the open vacancies area
    And close the openbetcareers page
