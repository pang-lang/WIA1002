
package Q1;

public class Tester {
    public static void main(String[] args) {
        MyGeneric <String> strObj = new MyGeneric <>();
        MyGeneric <Integer> intObj = new MyGeneric <>();
        
        strObj.setE("hello world");
        intObj.setE(123);
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
        
    }
    
}
