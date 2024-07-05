/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q5;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author panglang
 */
public class SortName {
    private static final String EN_ALPHABET = "ABC.DE..FGHIJ..KLMNOPQRS..TUVWXY.Z..";
    private static final String RU_ALPHABET = "АБЦЧДЕЁЭФГХИЙЯЮКЛМНОП.РСШЩТУВ..ЫЖЗЪЬ";
    
    public static void main(String[] args) {
        String[] names = {
            "DAVID", "ELIZABETH", "JAMES", "JENNIFER", "JOHN",
            "LINDA", "MARIA", "MICHAEL", "PATRICIA", "ROBERT",
            "AHTOHOB", "ВОЛКОВ", "ГУРИН" , "ИВАНОВ", "КОЛМОГОРОВ",
            "МАРИА", "МАРКОВ" , "ПЕТРОВ", "ПУТИН", "СТЕПАНОВ"};
        
        Comparator <String> comparator = new SpecialComparator<>();
        sort(names, comparator);
        System.out.println("# Sorted name list:");
        printArray(names, "\n - ");
        System.out.println("\n# Search");
        String[] search = {"AHTOHOB","MARKOV","МАРИА","ВОЛКОВ"};
        for (int i=0; i<search.length; i++){
            System.out.println("Index of " + search[i] + ": " + search(names,search[i]));
        }
        
        Comparator <String> compareLength = new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                int l1 = o1.length();
                int l2 = o2.length();
                return Integer.compare(l1, l2);
            }
        };
        System.out.println("Longest name index: " + findMax(names,compareLength));

    }
    
    public static void sort(String[] arr, Comparator <? super String> comparator){
        Arrays.sort(arr, comparator);
    }
    
    public static void printArray(String[] name, String deliminator){
        for (int i=0; i<name.length; i++){
            System.out.print(deliminator + name[i]);
        }
        System.out.println("");
    }
    
    public static <T> int search(String[] arr, String s){
        for (int i=0; i<arr.length; i++){
            if (arr[i].equals(s))
                return i;
        }
        return -1;
    }
    
    public static <T extends CharSequence> int findMax(T[] array, Comparator <? super T> comparator){
        int longestIndex = 0;
        for (int i=1; i<array.length; i++){
            if (comparator.compare(array[i], array[longestIndex]) > 0){
                longestIndex = i;
            }
        }
        return longestIndex;
    }
    
    public static class SpecialComparator <T extends CharSequence> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            int minLength = Math.min(s1.length(),s2.length());
            for (int i=0; i<minLength; i++){
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);

                int n1 = EN_ALPHABET.indexOf(ch1);
                int n2 = EN_ALPHABET.indexOf(ch2);

                if (n1 == -1)
                    n1 = RU_ALPHABET.indexOf(ch1);
                if (n2 == -1)
                    n2 = RU_ALPHABET.indexOf(ch2);

                if (n1 != n2)
                    return n1-n2;    
            }
            return s1.length()-s2.length();
        }
    }

}
