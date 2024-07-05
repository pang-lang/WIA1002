/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labtest2;

import java.util.EmptyStackException;

public class EntranceGateStack {
    private final int maxSize;
    private final String[] stackArray;
    private int top;
    
    public EntranceGateStack() {
        this.maxSize = 100;
        stackArray = new String[maxSize];
        top = -1;
    }
    
    // push - arrival
    public void assignGate(String gateNumber){
        if (isStackFull()) {
            throw new StackOverflowError("Stack is full");
        }
        stackArray[++top] = gateNumber;
    }
    
    // pop - departure
    public String releaseGate() {
        if (isStackEmpty()) 
            return "Stack is empty";

        String removedGate = stackArray[top];
        for (int i = top; i > 0; i--) {
            stackArray[i] = stackArray[i - 1];
        }
        stackArray[0] = null; // Clear the topmost element
        top--; // Decrement the top pointer

        return removedGate;
    }
    
    //peek
    public String checkTopGate(){
        return stackArray[top];
    }
    
    public boolean isStackEmpty(){
        return top == -1;
    }
    
    public boolean isStackFull(){
        return top == maxSize-1;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i=0; i<stackArray.length; i++){
            if (stackArray[i] != null)
                str.append(stackArray[i] + " ");
        }
        return str.toString();
    }
}
