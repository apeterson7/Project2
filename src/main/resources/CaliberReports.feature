Feature: Can navigate to the Week view of the Reports page

 
  Scenario: Selecting by Week
    Given I am on the Reports page and click the week dropdown
    When I select a week 
    Then I should see the quality audit panel


 