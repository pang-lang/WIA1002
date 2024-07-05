
package Q5;

public class Circle implements Comparable <Circle>{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public int compareTo(Circle b){
        return Double.compare(radius, b.radius);
        /*
        if (radius < b.radius)
            return -1;
        else if (radius == b.radius)
            return 0;
        else
            return 1;
        */
    }
    
    // ensure proper implementation
    public String toString(){
        return "Maximum radius: " + radius;
    }
}