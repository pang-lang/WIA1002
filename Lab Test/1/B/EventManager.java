
package labtest1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EventManager<T extends Event> {
    private ArrayList <T> events = new ArrayList<>();
    
    public void addEvent(T e){
        events.add(e);
    }
    
    public void getEvent(){
        for (Event e : events){
            System.out.println(e);
        }
    }
    
    public void display(){
        for (T e : events){
            e.displayEventDetails();
            System.out.println("");
        }
    }
}
