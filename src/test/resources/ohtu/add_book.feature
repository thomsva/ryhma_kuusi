Feature: As a user I can add a book

   Scenario: user can add a book with title, author and number of pages
      Given command add book is selected
      When  valid title "kirja" and author "kirjailija" and pages "100" are entered
      Then  system will respond with "Book added successfully"

   Scenario: user can not add a book if letters are entered for number of pages
      Given command add book is selected
      When valid title "kirja" and author "kirjailija" and invalid pages "10s" are entered
       Then system will respond with "Error in adding the bookmark"

   Scenario: user can not add a book if empty string is added for title
      Given command add book is selected
      When invalid title "" and  valid author "kirjailija" and valid pages "100" are entered
      Then system will respond with "Error in adding the bookmark"

   Scenario: user can not add a book if blank string is added for title
      Given command add book is selected
      When invalid title " " and  valid author "kirjailija" and valid pages "101" are entered
      Then system will respond with "Error in adding the bookmark"
   
   Scenario: user can not add a book if empty string is added for author
      Given command add book is selected
      When invalid title "ohtumaterial" and  valid author "" and valid pages "102" are entered
      Then system will respond with "Error in adding the bookmark"
   
   Scenario: user can not add a book if blank string is added for author
      Given command add book is selected
      When invalid title "ohtumaterial" and  valid author " " and valid pages "103" are entered
      Then system will respond with "Error in adding the bookmark"