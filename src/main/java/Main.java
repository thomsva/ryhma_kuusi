
import java.util.Scanner;
import io.ConsoleIO;
import io.IO;

public class Main {
    
     private IO io;
     
    public static void main(String[] args) {
          
        System.out.println("Welcome to BookMarkApp!");
       
        IO io = new ConsoleIO();
        new App(io).run();
       
        
         
   
    }
    
}