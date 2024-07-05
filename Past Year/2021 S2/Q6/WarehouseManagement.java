/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

import java.util.ArrayList;

/**
 *
 * @author panglang
 */

public class WarehouseManagement {
    private static final int MAX_CAPACITY = 1000;
    
    public static void main(String[] args) {
        int[] arr = new int[MAX_CAPACITY];
        for (int i = 0; i < MAX_CAPACITY; i++) {
            arr[i] = (int) (Math.random() * MAX_CAPACITY);
        }
        int key = 10;
        
        int t1 = linearSearch(arr, key);
        System.out.println("Time spent in linear search: " + t1 + " seconds");

        int t = bubbleSort(arr);
        int t2 = binarySearch(arr, key) + t;
        System.out.println("Time spent in binary search with bubble sort: " + t2 + " seconds");

        int tt = insertionSort(arr);
        int t3 = binarySearch(arr, key) + tt;
        System.out.println("Time spent in binary search with insertion sort: " + t3 + " seconds");

        comEff(t1, t2, t3);
    }
    
    public static int linearSearch(int[] list, int key){
        int time = 0;
        int pos = -1; 
        
        for (int i = 0; i < list.length; i++){
            if (key == list[i]){
                pos = i;
                break;
            } else {
                time += 15; 
            }
        }
        
        if (pos != -1) {
            System.out.println("Key found at position " + pos);
        } else {
            System.out.println("Key not found.");
        }
        return time;
    }
    
    public static int bubbleSort(int[] list){
        int time = 0;
        
        for (int i = 0; i < list.length - 1; i++){
            for (int j = 0; j < list.length - i - 1; j++){
                if (list[j] > list[j + 1]){
                    // Swap elements
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    time += 6; // 6 seconds per swap
                }
            }
        }
        return time;
    }
    
    public static int insertionSort(int[] list){
        int time = 0;
        
        for (int i = 1; i < list.length; i++){
            int current = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > current; j--){
                list[j + 1] = list[j];
                time += 6; // 6 seconds per swap
            }
            list[j + 1] = current;
        }
        return time;
    }
    
    public static int binarySearch(int[] list, int key){
        int time = 0;
        int low = 0;
        int high = list.length - 1;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (key > list[mid]){
                low = mid + 1;
            } else if (key < list[mid]){
                high = mid - 1;
            } else {
                System.out.println("Key found at position " + mid);
                return time; // Return time spent in seconds
            }   
            time += 6; // 6 seconds per comparison
        }
        System.out.println("Key not found.");
        return time;
    }
    
    public static void comEff(int t1, int t2, int t3){
        System.out.println(".".repeat(40) + "\nComparing efficiencies:");

        double timeLinearSearchMinutes = t1 / 60.0;
        double timeBubbleSortMinutes = t2 / 60.0;
        double timeInsertionSortMinutes = t3 / 60.0;

        System.out.println("Time spent in Linear Search: " + timeLinearSearchMinutes + " minutes");
        System.out.println("Time spent in Bubble Sort: " + timeBubbleSortMinutes + " minutes");
        System.out.println("Time spent in Insertion Sort: " + timeInsertionSortMinutes + " minutes");

        // Compare times and provide analysis
        if (t1 < t2 && t1 < t3) {
            System.out.println("Linear Search is the most efficient method for this dataset.");
        } else if (t2 < t1 && t2 < t3) {
            System.out.println("Bubble Sort is the most efficient sorting method for this dataset.");
        } else if (t3 < t1 && t3 < t2) {
            System.out.println("Insertion Sort is the most efficient sorting method for this dataset.");
        } else {
            System.out.println("Efficiencies are comparable. Consider other factors for decision making.");
        }
    }
}
    
