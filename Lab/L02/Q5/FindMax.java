
package Q5;

public class FindMax {
        public static <E extends Comparable <E>> E max(E[] list){
        E max = list[0];
        for (int i = 0; i < list.length; i++){
            if (list[i].compareTo(max) > 0){
                max = list[i];
            }
        }
        return max;
    }
}
    
