/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

import java.util.Comparator;

/**
 *
 * @author panglang
 */
public class DistanceComparator implements Comparator <Passenger>{

    @Override
    public int compare(Passenger o1, Passenger o2) {
        if (o1.getLocation().compareTo(o2.getLocation()) > 0)
            return 1;
        else if (o1.getLocation().compareTo(o2.getLocation()) < 0)
            return -1;
        else
            return 0;
    }
    
}
