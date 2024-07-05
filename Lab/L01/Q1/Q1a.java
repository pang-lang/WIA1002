
package Q1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q1a {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new FileInputStream("Kueh Pang Lang_23005227.txt"));
            while (input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (IOException e){
            System.out.println("Problem with input file.");
        }
    }
    
}

