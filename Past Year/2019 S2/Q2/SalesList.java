/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author panglang
 */
public class SalesList {
    private String region;
    private String name;
    private Integer amount;

    public SalesList(String region, String name, Integer amount) {
        this.region = region;
        this.name = name;
        this.amount = amount;
    }
    
    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public SalesList() {
    }

    public String toString(){
        return String.format("%-15s%-5d%s",region,amount,name);
    }
    
    public static void main(String[] args) {
        SalesList[] list = {new SalesList("Asia", "Ahmad", 450),
                            new SalesList("Europe","Hemish", 518),
                            new SalesList("Europe","Banny",650),
                            new SalesList("Greenland","Ain",200),
                            new SalesList("Asia","Ali",390),
                            new SalesList("Greenland","Ben",670),
                            new SalesList("Asia","Lee",790)};
        
        System.out.println("Original Data: ");
        for (SalesList s : list){
            System.out.println(s.toString());
        }
        
        SortSalesList.sortRegion(list);
        for (SalesList s : list){
            System.out.println(s.toString());
        }
        
        SortSalesList.sortAmount(list);
        for (SalesList s : list){
            System.out.println(s.toString());
        }
        
        SortSalesList.sortName(list);
        for (SalesList s : list){
            System.out.println(s.toString());
        }
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
