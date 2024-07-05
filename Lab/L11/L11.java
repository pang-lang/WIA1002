/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package l11;

/**
 *
 * @author panglang
 */
public class L11 {

    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        print(arr);
        selectionSortLargest(arr);
        print(arr);
        
        int[] arr1 = {10,34,2,56,7,67,88,42};
        insertionSort(arr1);
        print(arr1);
    }
    
    //Q1
    public static void selectionSortSmallest(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            int min = arr[i];
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++){
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            } if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void selectionSortLargest(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            int max = arr[i];
            int maxIndex = i;
            for (int j=i+1; j<arr.length; j++){
                if (max < arr[j]){
                    max = arr[j];
                    maxIndex = j;
                }
            } if (maxIndex != i){
                arr[maxIndex] = arr[i];
                arr[i] = max;
            }
        }
    }
    
    public static void insertionSort(int[] arr){
        for (int i=1; i<arr.length; i++){
            int current = arr[i];
            int k;
            for (k=i-1; k>=0 && arr[k] > current; k--){
                arr[k+1] = arr[k];
            }
            arr[k+1] = current;
        }
    }
    
    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
