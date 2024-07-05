/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

import java.util.PriorityQueue;

/**
 *
 * @author panglang
 */
public class Tester {
    public static void main(String[] args) {
        DistanceComparator c = new DistanceComparator();
        PriorityQueue <Passenger> queue = new PriorityQueue<>(c);
        Passenger[] passengers = {new Passenger("Susan", "Road 0.9"),
                                new Passenger("Jack","Road 5.5"),
                                new Passenger("Benjamin", "Road 1.6"),
                                new Passenger("Rachel", "Road 3.8"),
                                new Passenger("Samuel", "Road 4.1"),
                                new Passenger("Kenneth", "Road 2.6")};
        for (int i=0; i<passengers.length; i++){
            queue.offer(passengers[i]);
        }
        System.out.println("Passenger drop-off list");
        while (!queue.isEmpty()){
            Passenger p = queue.poll();
            System.out.println(getBusStop(p.getLocation())+ " " + p.getName());
        }
    }
    
    public static String getBusStop(double location){
        if (location < 2){
            return "Stop A";
        } else if (location < 3){
            return "Stop B";
        } else if (location < 4){
            return "Stop C";
        } else if (location < 5){
            return "Stop D";
        } else {
            return "Stop E";
        }
    }
    
    
}
  
                      