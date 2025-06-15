
@tag
Feature: Upload the document
  I want to use this template for my feature file

  @tag1
  Scenario: Document upload in the account successfully
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      
      
      
 Feature: Document Upload Functionality

  Scenario: Successful Document Upload, Download, Email, Edit, and Delete
    Given I am logged in and on the Clients page
    And I search for a client named "Mrunal Patil"
    When I open the chart for "Mrunal Patil"
    And I navigate to the "Documents" tab
    And I click on the "Add Document" button
    And I enter "Test_document" as the document name
    And I upload a file as the document content
    And I save the document
    Then I should see a success message indicating the document was saved
    When I click on the "Download Document" button
    And I click on the "Send Email" button
    And I ensure the email and name fields are populated or I enter "akash.todewale@bostonbyte.com" and "Rockey"
    And I click on the "Send Mail" submit button
    Then I should see a success message indicating the email was sent
    When I click on the "Edit Document" button
    And I update the document name to "Document test"
    And I save the edited document
    Then I should see a success message indicating the document was updated
    When I click on the "Delete Document" button
    And I confirm the deletion
    Then I should see a success message indicating the document was deleted
  
  
      
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
      