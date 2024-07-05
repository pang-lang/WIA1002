package Q4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panglang
 */
public class MyHashMap {
    protected Entry[] list;
    protected int size;

    public MyHashMap() {
        this.list = new Entry[10];
        this.size = 0;
    }
    
    public Entry get(String s){
        for (int i=0; i<size; i++){
            if (list[i].getKey().equals(s)){
                return list[i];
            }
        }
        return null;
    }
    
    public void put(String s, String t){
        for (int i=0;i <size; i++){
            if (list[i].getKey().equals(s)){
                list[i].setValue(t);
                return;
            }
        }
        if (size == list.length){
            resize();
        }
        list[size] = new Entry(s,t);
        size++;
    }
    
    public void resize(){
        Entry[] newList = new Entry[size*2];
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }
    
}
/*
Use size to track the number of elements that are currently stored in the array.
Use list.length to determine the total capacity of the array.
*/