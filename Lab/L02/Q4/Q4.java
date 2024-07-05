
public class Q4 {
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red","blue","orange","tan"};
        
        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
    
    public static <T extends Comparable <T>> String minmax(T[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        
        T max = arr[0];
        T min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
            if (arr[i].compareTo(min) < 0){
                min = arr[i];
            }
        }
        return "Min: " + min + "\nMax: " + max;
    }
}
