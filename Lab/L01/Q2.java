
package Q2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        System.out.println("character separated by comma");
        try {
            Scanner input = new Scanner (new FileInputStream("text1.txt"));
            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] c = line.split(",");
                for (int i=0; i<c.length; i++){
                    System.out.print(c[i]);
                }
                System.out.println("");
            }
            input.close();
        } catch (IOException e){
            System.out.println("Problem with input file.");
        }
        
        System.out.println("\nnumbers separated by comma and space");
        try {
            Scanner input = new Scanner (new FileInputStream("text2.txt"));
            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] c = line.split(", ");
                for (int i=0; i<c.length; i++){
                    System.out.print(c[i]);
                }
                System.out.println("");
            }
            input.close();
        } catch (IOException e){
            System.out.println("Problem with input file.");
        }
        
        System.out.println("\nreal numbers separated by semicolon and space");
        try {
            Scanner input = new Scanner (new FileInputStream("text3.txt"));
            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] c = line.split("; ");
                for (int i=0; i<c.length; i++){
                    System.out.print(c[i]);
                }
                System.out.println("");
            }
            input.close();
        } catch (IOException e){
            System.out.println("Problem with input file.");
        }
        
        System.out.println("\nalphabets separated by numbers");
        try {
            Scanner input = new Scanner (new FileInputStream("text4.txt"));
            while (input.hasNextLine()){
                String line = input.nextLine();
                String l = line.replaceAll("[0-9]","");
                System.out.println(l);
            }
            input.close();
        } catch (IOException e){
            System.out.println("Problem with input file.");
        }
        // /d digit
        // /w word character
        // /s all whitespace
        // ???+ 0 or many, * 0 or more, ? 0/1, 
    }

    
}
