
package Q5;

public class Tester {
    public static void main(String[] args) {
        Integer[] intArr = {1,2,3};
        String[] strArr = {"red","green","blue"};
        Circle[] obj = {new Circle(3),new Circle(2.9),new Circle(5.9)};
        
        System.out.println(FindMax.max(intArr));
        System.out.println(FindMax.max(strArr));
        System.out.println(FindMax.max((obj)));
    }
}
    

