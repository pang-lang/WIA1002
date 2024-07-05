
package Q1;

import java.util.ArrayList;

public class ArrList <T> {

    public static void display(ArrayList<? extends Number> elements){
        for (Number element : elements){
            System.out.print(element + " ");
        } System.out.println("");
        
    }
    public static <T> void main(String[] args) {
        ArrayList <Integer> numOfCars = new ArrayList <>();
        ArrayList <Double> milesPerHour = new ArrayList <>();
        
        numOfCars.add(5);
        numOfCars.add(3);
        numOfCars.add(7);
        
        milesPerHour.add(48.5);
        milesPerHour.add(67.3);
        milesPerHour.add(23.9);
        
        display(numOfCars);
        display(milesPerHour);
        
        
    }
    
}


/*
ArrayList <T> elements; 

    public ArrList(ArrayList<T> elements) {
        this.elements = elements;
    }
    
    public static <T> void display(ArrayList<T> elements){
        for (T element : elements){
            System.out.print(element + " ");
        } System.out.println("");
        
    }
    public static <T> void main(String[] args) {
        ArrayList <Integer> numOfCars = new ArrayList <>();
        ArrayList <Double> milesPerHour = new ArrayList <>();
        
        numOfCars.add(5);
        numOfCars.add(3);
        numOfCars.add(7);
        
        milesPerHour.add(48.5);
        milesPerHour.add(67.3);
        milesPerHour.add(23.9);
        
        display(numOfCars);
        display(milesPerHour);
        
        
    }
    
}

*/