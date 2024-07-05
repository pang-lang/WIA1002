/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package l10;

/**
 *
 * @author panglang
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(substituteAI("flabbergasted"));
        System.out.println(substituteAI("Astronaut "));        
    }
    
    public static String substituteAI(String str){
        if (str.length() == 0)
            return "";
        else if (str.charAt(0) == 'a')
            return 'i' + substituteAI(str.substring(1));
        else
            return str.charAt(0) + substituteAI(str.substring(1)); 
    }
}
