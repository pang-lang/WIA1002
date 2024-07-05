/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

public class Day {
    public static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify you day in number :"
                + "\n1 for Monday\n2 for Tuesday\n3 for Wednesday\n4 for Thursday\n5 for Friday\n6 for Saturday\n7 for Sunday");
        int day = sc.nextInt();
        String d = getDays(day);
        System.out.println("The name of the day is : "  + d);
        System.out.println("The following day of " + d + " is : " + getDays(day + 1));
        System.out.println("The previous day of " + d + " is : " + getDays(day - 1));
        System.out.println("How many days to add to the specified/current day (" + d +")? : ");
        int days = sc.nextInt();
        System.out.println("The new day after the addition of " + days + " day(s) is : " + getDays(day + days));
    }
    
    public static String getDays(int day){
        return days[day % 7];
    }
   
}
