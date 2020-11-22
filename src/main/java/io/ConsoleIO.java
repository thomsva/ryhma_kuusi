package io;

import java.util.Scanner;

public class ConsoleIO implements IO {
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * print output
     */
    public void print(String toPrint) {
        System.out.println(toPrint);
    }
    
    /**
     * read integer
     */
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
    
    /**
     * read string
     */
    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    
}