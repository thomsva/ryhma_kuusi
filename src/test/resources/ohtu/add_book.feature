Feature: As a user I can add a book

    Scenario: user can add a book with title, author and number of pages
       Given command add book is selected
       When  valid title "kirja" and author "kirjailija" and pages 100 are entered
       Then  system will respond with "Book added successfully"