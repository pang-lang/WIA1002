/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author panglang
 */
public class Tester {
    public static void main(String[] args){
        String[][] arr = new String[5][5];
        System.out.println("The Triwizard Maze: ");
        readFile("maze.txt");    
        System.out.println("");
        readFile("maze2.txt");    
    }

    public static void readFile(String filename){
        String[][] arr = new String[5][5];
        try {
            BufferedReader read = new BufferedReader(new FileReader(filename));
            String l;
            int row = 0;
            
            while ((l = read.readLine()) != null){
                String[] line = l.split(" ");
                for (int i = 0; i < arr[row].length; i++) {
                    arr[row][i] = line[i];
                }
                row++;
            }
            read.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e){
            System.out.println("Error reading input file.");
        }
        
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        mazeSolver(arr);
    }
    
    
    public static void mazeSolver(String[][] arr){
        Stack <Integer> stack = new Stack<>();
        boolean[][] visited = new boolean[5][5];
        boolean found = false;
        stack.push(0, 0);
        visited[0][0] = true;
        
        while (!stack.isEmpty()){
            String[] currentPos = stack.peek().substring(1, stack.peek().length() - 1).split(",");
            int x = Integer.parseInt(currentPos[0]); 
            int y = Integer.parseInt(currentPos[1]); 
            
            if (arr[x][y].equals("C")){
                System.out.println(stack.toString());
                found = true;
                break;
            }
            
            boolean moved = false;
            int row = arr.length;
            int column = arr[0].length; 
            
            // Move up
            if (y < row - 1 && !arr[x][y + 1].equals("0") && !visited[x][y + 1]) {
                stack.push(x, y + 1);
                visited[x][y + 1] = true;
                moved = true;
            }
            // Move right
            else if (x < column - 1 && !arr[x + 1][y].equals("0") && !visited[x + 1][y]) {
                stack.push(x + 1, y);
                visited[x + 1][y] = true;
                moved = true;
            }
            // Move down
            else if (y > 0 && !arr[x][y - 1].equals("0") && !visited[x][y - 1]) {
                stack.push(x, y - 1);
                visited[x][y - 1] = true;
                moved = true;
            }
            // Move left
            else if (x > 0 && !arr[x - 1][y].equals("0") && !visited[x - 1][y]) {
                stack.push(x - 1, y);
                visited[x - 1][y] = true;
                moved = true;
            }

            
            if (!moved){
                stack.pop();
            }
        }
        
        if (!found){
            System.out.println(stack.toString());
        }   
    }
}
