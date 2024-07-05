/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class Tester {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        
        myHashMap.put("BruceW", "011-8989890");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402009");
        
        
        Entry e1 = myHashMap.get("DeanW");
        System.out.println("Value: " + e1.getValue());
        
        Entry e2 = myHashMap.get("TonyS");
        System.out.println("Value: " + e2.getValue());
        
        myHashMap.put("BruceW", "011-5677900");
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("Value: " + e3.getValue());
        
        myHashMap.put("JeanG", "019-9001123");
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("Value: " + e4.getValue());
    }
}
