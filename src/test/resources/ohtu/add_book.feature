Feature: As a user I can add a book

   Scenario: user can add a book with title, author, number of pages and current page
      Given command add book is selected
      When  valid title "kirja" and author "kirjailija" and pages "100" and current page "12" are entered
      Then  system will respond with "Book added successfully"

   Scenario: user can not add a book if letters are entered for number of pages
      Given command add book is selected
      When valid title "kirja" and author "kirjailija" and invalid pages "10s" and current page "12" are entered
      Then system will respond with "Error in adding the bookmark"

   Scenario: user can not add a book if empty string is added for title
      Given command add book is selected
      When invalid title "" and  valid author "kirjailija" and valid pages "100" and current page "12" are entered
      Then system will respond with "Error in adding the bookmark"

   Scenario: user can not add a book if blank string is added for title
      Given command add book is selected
      When invalid title " " and  valid author "kirjailija" and valid pages "101" and current page "12" are entered
      Then system will respond with "Error in adding the bookmark"
   
   Scenario: user can not add a book if empty string is added for author
      Given command add book is selected
      When valid title "ohtumaterial" and  invalid author "" and valid pages "102" and current page "12" are entered
      Then system will respond with "Error in adding the bookmark"
   
   Scenario: user can not add a book if blank string is added for author
      Given command add book is selected
      When valid title "ohtumaterial" and  invalid author " " and valid pages "103" and current page "12" are entered
      Then system will respond with "Error in adding the bookmark"

   Scenario: when user input is invalid then correct output
      When command "ad bok" is selected
      Then system will respond with "unknown command"

   Scenario: User can not add a book if current page is less than 0
      Given command add book is selected
      When valid title "kirja" and author "kirjailija" and valid pages "100" and invalid current page "-1" are entered
      Then system will respond with "Error in adding the bookmark"

   Scenario: User can not add a book if current page is bigger than books's total pages
      Given command add book is selected
      When valid title "kirja" and author "kirjailija" and valid pages "100" and invalid current page "105" are entered
      Then system will respond with "Error in adding the bookmark"

  Scenario: User can not add a book if current page contains letters
      Given command add book is selected
      When valid title "kirja" and author "kirjailija" and valid pages "100" and invalid current page "1s" are entered
      Then system will respond with "Error in adding the bookmark"
      