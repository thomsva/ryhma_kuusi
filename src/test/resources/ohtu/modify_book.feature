Feature: As a user I can modify book
   Scenario: user can update the current page number
      Given command modpage is selected
      When book's id "2" is entered and current page "20" is entered
      And command list is selected
      Then list will contain "Id: 2 | Title: kirja | Author: kirjailija | Number of pages: 100 | Current page: 20"

      