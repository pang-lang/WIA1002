
package Q3;
                             
public class StorePairGeneric <T extends Comparable <T>> implements Comparable <StorePairGeneric <T>> {
    private T first, second;

    public StorePairGeneric(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
    
    
    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    //object is the highest class that every other class inherits from
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;

        //downcasting the object into SotrePairGeneric
        StorePairGeneric<?> another = (StorePairGeneric<?>) obj;
        return this.first.equals(another.first);
    } 
    
    @Override
    public int compareTo(StorePairGeneric<T> another) {
        return this.first.compareTo(another.first);
    }
    
    @Override
    public String toString(){
        return "first = " + first + " second = " + second;
    }
}
