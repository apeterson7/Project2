Feature: Simple things on Caliber's Manage page work
  
  Scenario: View Batch Trainees
    Given I am on the Manage page
    When I click on the human icon
    Then The View Batch Trainees modal should appear
