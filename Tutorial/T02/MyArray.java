
package Q1;

public class MyArray <T> {
    public static <T> void display(T[] elements){
        for (T element : elements){
            System.out.print(element + " ");
        } System.out.println("");
    }


    public static void main(String[] args) {
        Integer[] num = {1,2,3,4,5};
        String[] names = {"Jane","Tom","Bob"};
        Character[] alphabet = {'a','b','c'};
        
        display(num);
        display(names);
        display(alphabet);
        
    }
      
}
