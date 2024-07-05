
package Q3;

public class Tester {
    public static void main(String[] args) {
        System.out.println("****** Account *******");
        Account a = new Account(1122,20000);
        a.withdraw(2500);
        a.deposit(3000);
        
        System.out.println(a.toString());
        
        System.out.println("\n****** Account 1 ******");
        Account1 a1 = new Account1 ("George",1122,1000);
        a1.deposit(30, "Deposit $30");
        a1.deposit(40, "Deposit $40");
        a1.deposit(50, "Deposit $50");
        
        a1.withdraw(5, "Withdraw $5");
        a1.withdraw(4, "Withdraw $4");
        a1.withdraw(2, "Withdraw $2");
        
        System.out.println(a1.toString());
        a1.printTransactions();
    }
    
}
