Feature: Document Upload Functionality for Client

  Scenario: Upload, email, edit, and delete a document for a client

    Given I am logged into the application
    When I navigate to the Clients tab
    And I search for a client with first name "Mrunal" and last name "Patil"
    And I open the chart of the client
    And I navigate to the Documents tab
    And I click on the Add Document button
    And I enter the document name "Test_document"
    And I upload a screenshot as the document file
    And I click on the Save Document button
    Then I should see a success message confirming the document was saved

    When I download the uploaded document
    And I click on the Send Email button
    Then I should see email and name fields pre-filled or fill them manually
    And I submit the email form
    Then I should see a success message confirming the email was sent

    When I edit the document name to "Document test"
    And I save the changes
    Then I should see a success message confirming the document was edited

    When I delete the document
    And I confirm the deletion
    Then I should see a success message confirming the document was deleted
