/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author panglang
 */
import java.util.Scanner;
import java.util.ArrayList;
public class PrintPages {
    public static void main(String[] args) {
        SpecialLL<Integer> bookPage = new SpecialLL<>();
        ArrayList<Integer> selectedList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting page: ");
        int start = input.nextInt();
        System.out.print("Enter number of pages: ");
        int page = input.nextInt();
        for (int i=start; i<=start + page - 1; i++){
            bookPage.addLast(i);
        }
        bookPage.printOdd();
        System.out.println("");
        selectedList=bookPage.getEven();
        System.out.println(" " + selectedList.reversed());
    }
}