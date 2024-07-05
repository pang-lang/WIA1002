
package Q3;

import java.util.ArrayList;

public class Account1 extends Account{
    private String name;
    protected ArrayList <Transaction> transactions;

    public Account1(String name, int id, double balance) {
        super(id, balance);
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public double deposit (double amount, String description){
        this.balance += amount;
        transactions.add(new Transaction('D', amount, balance, description));
        return getBalance();
    }
    
    public boolean withdraw (int amount, String description){
        if (amount <= getBalance()) {
            this.balance -= amount;
            transactions.add(new Transaction('W', amount, balance, description));
            return true;
        } return false;
    }
    
    public String toString(){
        return "Name: " + name + "\n" + super.toString() + "\nTransaction history : \n";
    }
    
    public void printTransactions(){
        System.out.printf("%s %4s %4s %s","Type","Amount","Balance","Description\n");
        for (Transaction t : transactions){
            t.printDetails();
            System.out.println("");
        }
    }
   
}
