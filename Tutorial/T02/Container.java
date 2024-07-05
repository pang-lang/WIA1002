
package Q1;

public class Container <T> {
    //declare variable
    private T t;

    //no arg constructor
    public Container() {
    }

    
    public Container(T t) {
        this.t = t;
    }
    
    public void add(T a){
        this.t = a; 
    }
    
    public T retrieve(){
        return t;
    }
    
    public static void main(String[] args) {
        Container <Integer> c1 = new Container <>();
        Container <String> c2 = new Container <>();
        
        c1.add(50);
        c2.add("Java");
        System.out.println(c1.retrieve());
        System.out.println(c2.retrieve());
    }
}
