Feature: As a user, I can list all bookmarks

    Scenario: user can see list containing books created
    Given command add book is selected
    And create book title "ohtu diary", author "student" and pages "101"
    When command list is selected
    Then system will respond with "Id: 0 | Title: ohtu diary | Author: student | Number of pages: 101 | Current page: 0"