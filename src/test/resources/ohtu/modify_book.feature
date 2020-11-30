Feature: As a user I can modify book

   Scenario: user can update the current page number
      Given command modpage is selected
      When book's id "2" and current page "20" is entered
      And command list is selected
      Then list will contain "Id: 2 | Title: kirja | Author: kirjailija | Number of pages: 100 | Current page: 20"

   Scenario: user cannot add page number that contains letters
      Given command modpage is selected
      When book's id "2" and invalid current page "2o" is entered
      Then system will respond with "Error! ID and page should be numbers."

   
   Scenario: user cannot add invalid id that contains letters
      Given command modpage is selected
      When invalid book's id "e" and valid current page "20" is entered
      Then system will respond with "Error! ID and page should be numbers."
      