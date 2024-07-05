/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author panglang
 */
public class LuckDraw {
    public static void main(String[] args) {
        LinkedList <Staff> stafflist1 = new LinkedList<>();
        try {
            Scanner reader = new Scanner(new FileInputStream("StaffList.txt"));
            String ind = reader.nextLine();
            
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(" ");
                int ID = 0;
                String name = null, pos = null;
                for (int i=0; i<parts.length; i++){
                    ID = Integer.parseInt(parts[0]);
                    if (parts.length == 3){
                        name = parts[1];
                    } else {
                        name = parts[1] + " " + parts[2];
                    }
                    pos = parts[parts.length-1];
                }
                Staff s = new Staff(ID, name, pos);
                stafflist1.addLast(s);
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Input file not found.");
        }
        
        LinkedList <Staff> stafflist2 = stafflist1.clone();
        List <Integer> selectedIndex = new ArrayList<>();
        int count = 0;
        while (count < 5){
            int randNum = (int)(Math.random()*stafflist1.getSize());
            if (!selectedIndex.contains(randNum)){
                selectedIndex.add(randNum);
                Staff s = stafflist1.get(randNum);
                System.out.println(s.getID() + " " + s.getName() + " wins a drone!");
                count++;
            } else {
                continue;
            }
        }
        
        System.out.println("\nLUCKY DRAW 2" + "-".repeat(50));
        int price = 1000;
        while (price != 0){
            int randNum = (int)(Math.random()*11);
            Staff s = stafflist2.get(randNum);
            if (s.getPosition().equals("Assisstant")){
                price -= 200;
                System.out.println(s.getPosition() + " " + s.getName() + " " + "wins RM200. Cash vouchers left RM" + price);
            } else if (s.getPosition().equals("Supervisor")){
                price -= 100;
                System.out.println(s.getPosition() + " " + s.getName() + " " + "wins RM100. Cash vouchers left RM" + price);
            } else if (s.getPosition().equals("Manager")){
                System.out.println(s.getPosition() + " " + s.getName() + " " + "is the winner but no cash voucher will be given.");
            }
        }
        
    }
    
    
}
/*
Staff[] staffs = {new Staff(1, "Luke Skywalker","Manager"),
            new Staff(2, "Han Solo","Supervisor"),
            new Staff(6, "Moff Tarkin","Assistant"),
            new Staff(8, "Obi Wan","Assistant"),
            new Staff(9, "Organa","Assistant"),
            new Staff(12, "Leia Organa","Supervisor"),
            new Staff(15, "Chewbacca","Assistant"),
            new Staff(16, "Uncle Owen","Assistant"),
            new Staff(17, "Aunt Beru","Assistant"),
            new Staff(19, "Lando Calrissian","Assistant"),
        };
        for (int i=0; i<staffs.length; i++){
            stafflist1.addLast(staffs[i]);
        }
        System.out.println(stafflist1.toString());
*/