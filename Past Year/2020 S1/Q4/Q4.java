/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class Q4 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        System.out.println("New directory entry: "); 
        myHashMap.put("BruceW", "011-8998990"); 
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800"); 
        myHashMap.put("LaraC", "014-6402009");
        System.out.println("");
        System.out.println("Get directory: ");
        Entry e1 = myHashMap.get("DeanW");
        System.out.println("DeanW: " + e1.getValue());
        Entry e2 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e2.getValue());
        System.out.println("");
        System.out.println("Update directory: "); 
        myHashMap.put("BruceW", "011-5677900"); 
        myHashMap.put("JeanG", "019-9001123");
        // Get directory:
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e3.getValue());
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("JeanG: " + e4.getValue());
    }
    
}
