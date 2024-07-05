
package t9;

public class T9 {

    public static void main(String[] args) {
        // can use as boolean array
        
        int[][] arr = {{0,0,1,1,0,0,0,0,0},
                       {0,0,0,1,0,0,0,0,0},
                       {0,0,0,0,1,1,0,0,0},
                       {0,0,0,0,1,0,0,0,0},
                       {0,0,0,0,0,0,1,0,0},
                       {0,0,0,0,0,0,0,1,0},
                       {0,0,0,0,0,0,0,1,0},
                       {0,0,0,0,0,0,0,0,1},
                       {0,0,0,0,0,0,0,0,0}}; 
        
        System.out.print("  ");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print((char)('A' + i) + " ");
        }
        System.out.println();


        for (int i = 0; i < arr.length; i++) {
            System.out.print((char)('A' + i) + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }           
        
    }
    
}
