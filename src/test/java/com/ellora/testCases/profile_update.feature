Feature: Update User Profile

  Scenario: Successfully update the user profile fields
    Given User is logged into the application
    When User navigates to the Profile page
    And User updates profile with the following details:
      | FirstName     | Sam               |
      | MiddleName    | A                 |
      | LastName      | Doc               |
      | ContactNumber | 9876543210        |
      | Email         | samdoc@example.com|
      | EmployeeID    | EMP001            |
    And User selects SMS opt-in as "Yes"
    And User selects Subscribed as "Yes"
    And User clicks the Save button
    Then Success message "User updated successfully" should be displayed
