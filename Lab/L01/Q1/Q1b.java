
package Q1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Q1b {
    public static void main(String[] args) {
        try {
            //add true to append a string in an existing file
            PrintWriter output = new PrintWriter(new FileOutputStream("Kueh Pang Lang_23005227.txt",true));
            output.append("\nMonday 24 June 2024\n" + "It’s me again. Finally, it’s the end of the term and the DS class has finished! "
                    + "I think I did. Well, i this semester i think i did pretty well with all of my subjects especially Data Structure as I constantly practice "
                    + "my programming and train my logic to become more familiarise with the questions. I am very happy to achieve what I had yearn for." +
                    "By learning DS, I am able to use my knowledge to program certain projects and even winning some competitions." +
                    "I hope there will not be changes in my target grade and I am confident to achieve more in future endeavours! ");
            output.close();
            
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e){
            System.out.println("Problem with output file.");
        }
  
    }
    
}
