/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
    public class Entry {
        protected String key;
        protected String value;
        protected Entry next;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
        
        public String toString(){
            return key + value;
        }
    }    
    

