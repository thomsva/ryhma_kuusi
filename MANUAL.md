# User manual

### Getting the program to run

You can download the newest version of the application from the [releases-page](https://github.com/LindaJT/ryhma_kuusi/releases).

The program is a jar-file. You can run such a file using Java, which itself supports multiple operating systems, such as Windows and Mac OSX among various Linux- and BSD -based systems. Make sure that you have a sensibly modern version of Java installed on your system.

Run the program using your system's command line (for example, in Windows it would be 'cmd.exe'). On the command line, navigate to the folder where you downloaded the jar-file and run the command `java -jar shadowJar.jar` (where the last part is the file's name -- change it if needed).

Please note that using the application will cause a database file 'bookmark.db' to be created in the jar-file's folder. This file contains your saved data regarding the bookmarks, so avoid manipulating it in any way.

### Using the application

The functionality of the application is listed when the application is launched. 

Adding a book to bookmarks can be done with the command **`add book`** or the shortcut **`a`**. The app then asks for the title, author, page count and the current page of the book. With the exception of the current page, all information is mandatory in order to add a bookmark. If current page is left empty, it will be 0.

All recorded bookmarks can be listed using the command **`list`** or the shortcut **`l`**. In this case, a list of information for all books is printed, including id, name, author, page number and current page. 

The current page number can be modified using the command **`modpage`** or the shortcut **`m`**. Book selection occurs based on the id you can find out using the `list` command. The new page number may be at most the stated page count of the book. 

The command **`help`** or the shortcut **`h`** prints a list of program functionality and commands to use them.

### Building from source

Use command **`./gradlew ShadowJar`**  in the directory where the code of the application is located.
