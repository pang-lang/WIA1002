
package Q3;

import java.util.Date;

public class Account {
    private int id;
    double balance;
    private double annualInterestRate = 4.5;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
    }
    
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate/100;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    
    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public double deposit (double amount){
        
        return balance += amount;
    }
    
    public double withdraw (int amount){
        if (amount <= balance) {
            balance -= amount;
        } 
        return balance;
    }
    
    public String toString(){
        return "Balance\t: " + balance + "\nMonthly Interest: " +  getMonthlyInterest() + "\nDate\t: " + dateCreated;
    }
    
}
