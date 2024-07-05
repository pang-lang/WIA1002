
package Q1;

public class Duo <A,B>{
    A first;
    B second;

    public Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }
    
    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("Square",5);
        Duo<Double, Double> points = new Duo<>(4.5,6.7);
       
    }
}
