
//q2

public class CompareMax {
    public static void main(String[] args) {
        Integer i =  maximum( 3,5,4);
        System.out.println( i);
        
        String s = maximum("Ahmad","Lily", "Monique");
        System.out.println(s);
        
        //uppercase comes before lowercase
        Character c = maximum('Z','t','U');
        System.out.println(c);
    }
    
    public static <T extends Comparable <T>> T maximum(T a, T b, T c){
        if (b.compareTo(a) > 0 && b.compareTo(c) > 0){
            return b;
        } if (c.compareTo(a) > 0 && c.compareTo(b) > 0){
            return c;
        } if (a.compareTo(b) > 0 && a.compareTo(c) > 0){
            return a;
        }
        return null;
    }
}

/*    
//modular code - breaking into small function
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if (y.compareTo(max) > 0){
            max = y;
        } if (z.compareTo(max) > 0){
            max = z;
        }
        return max;
    }
}
*/