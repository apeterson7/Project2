Feature: Assess Batch page can add a new week

  Scenario: Clicking the plus button reveals the creation window
    Given I am on the Assess page for the batch I want
    When I click on the plus button
    Then I should be able to see the new window 