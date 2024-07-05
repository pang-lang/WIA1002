
package labtest1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventManagementSystem {
    public static void main(String[] args) {
        
        EventManager e = new EventManager();
        
        try {
            Scanner input = new Scanner(new FileInputStream("events.txt"));
            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] l = line.split(",");
                if (l[0].equals("Concert")){
                    Concert c = new Concert(l[1], l[2], l[3], l[4]);
                    e.addEvent(c);
                }
                
                if (l[0].equals("Workshop")){
                    Workshop w = new Workshop(l[1], l[2], l[3], l[4],l[5]);
                    e.addEvent(w);
                }
                
                if (l[0].equals("SportsGame")){
                    SportsGame s = new SportsGame(l[1], l[2], l[3],l[4]);
                    e.addEvent(s);
                }
                  
            }
            input.close();

        } catch(IOException i){
            System.out.println("Problem with input file.");
        }
        e.display();
    }
        
}
    
