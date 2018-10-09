Feature: Home Page is up and running

  Scenario: Login
    Given I am on the Login Page
    When I submit the correct credentials
    Then I should be at Home Page

  Scenario: Check Header
    Given I am on the Home Page
    Then I should get the correct header

  Scenario: Florida Quality Audit
    Given I am on the Home Page
    When I select Florida's Quality Audits
    Then I should see that Blake Kruppa is the first quality audit

  Scenario: Virginia Quality Audit
    Given I am on the Home Page
    When I select Virginia's Quality Audits
    Then I should see that Patrick Walsh is the first quality audit

  Scenario: New York Quality Audit
    Given I am on the Home Page and click states dropdown
    When I select New York's Quality Audits
    Then I should see that Ryan Lessley is the first quality audit

  Scenario: Florida Weekly Progress
    Given I am on the Home Page and click states dropdown
    When I select Florida's Weekly Progress
    Then I should see that Steven Kelsey is the first weekly progress report

  Scenario: Virginia Weekly Progress
    Given I am on the Home Page and click states dropdown
    When I select Virginia's Weekly Progress
    Then I should see that is Patrick Walsh first weekly progress report

  Scenario: New York Weekly Progress
    Given I am on the Home Page and click states dropdown
    When I select New York's Weekly Progress
    Then I should see that Ryan Lessley is the first weekly progress report
