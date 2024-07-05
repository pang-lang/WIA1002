/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author panglang
 */
public class SortSalesList {
    
    //selection sort in descending
    public static void sortRegion(SalesList[] arr){
        System.out.println("\nSorting Result on Region using SelectionSort: ");
        for (int i=0; i<arr.length-1; i++){
            String max = arr[i].getRegion();
            int maxIndex = i;
            for (int j = i+1; j<arr.length; j++){
                if (max.compareTo(arr[j].getRegion()) < 0){
                    max = arr[j].getRegion();
                    maxIndex = j;
                }
            }
            if (maxIndex != i){
                SalesList temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
    
    //insertion sort in ascending
    // if were to user compareTo, use Integer as int cannot be deferenced
    public static void sortAmount(SalesList[] arr){
        System.out.println("\nSorting Result on Sales using InsertionSort: ");
        for (int i=1; i<arr.length; i++){
            SalesList current = arr[i];
            int k = i-1;
            while (k>= 0 && arr[k].getAmount().compareTo(current.getAmount()) > 0){
                arr[k+1] = arr[k];
                k--;
            }
            arr[k+1] = current;
        }
    }
    
    //bubble sort in ascending
    public static void sortName(SalesList[] arr){
        System.out.println("\nSorting Result on SalesRep using BubbleSort: ");
        for (int i=1; i<arr.length; i++){
            for (int j=0; j<arr.length-i; j++){
                if (arr[j].getName().compareTo(arr[j + 1].getName()) > 0){
                    SalesList temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    
}
