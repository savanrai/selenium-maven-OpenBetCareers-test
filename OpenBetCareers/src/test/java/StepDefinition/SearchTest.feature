Feature: Search for a specific vacancy
  Verify if user is able to search specific vacancy

  Scenario Outline: Search for a specific vacancy
    Given user is on openbetcareers homepage
    And clicks on vacancies
    And Keywords field is available to the user
    When User Enters Keywords "<keyword>"
    And user presses Enter
    Then new results should be displayed
    
	Examples: 
      |	keyword	|
      | java |
      | testing |
      | xyz |