/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class Passenger{
    protected String name;
    protected String location;

    public Passenger(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Double getLocation(){
        String[] parts = this.location.split(" ");        
        return Double.parseDouble(parts[1]);
    }

    public String toString(){
        return name + " " + location;
    }
}
