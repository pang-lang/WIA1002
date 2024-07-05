
package Q3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Buy 100 shares at $10 each
Buy 100 shares at $10 each
Sell 50 shares at $20 each
Sell 60 shares at $30 each
Sell 50 shares at $35 each
 */

public class Stock {
    private static LinkedList<Integer> shareQ = new LinkedList<>();
    private static Queue<Integer> priceQ = new LinkedList<>();
    private static int totalCapitalGain = 0;
    
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String s = sc.nextLine();
            if (s.isBlank())
                break;
            
            String[] ss = s.split(" ");
            int share = Integer.parseInt(ss[1]);
            int price = Integer.parseInt(ss[4].replace("$", ""));
            if (s.startsWith("Buy")) {
                buy(share, price);
            } else if (s.startsWith("Sell")) {
                sell(share, price);
            }
            System.out.println("Queue for Share: " + shareQ.toString());
            System.out.println("Queue for Price: " + priceQ.toString());
        }
    }

    public static void buy(int share, int price) {
        System.out.println("Buying now ...");
        waiting(1000);
        shareQ.offer(share);
        priceQ.offer(price);
    }

    private static void sell(int share, int price) {
        System.out.println("Selling the shares now ...");
        while (share > 0) {
            // ensure each share has a corresponding price.
            assert shareQ.size() == priceQ.size();
            if (shareQ.isEmpty()) {
                System.out.println("No shares to sell!");
                break;
            }
            //sells share available
            if (share >= shareQ.peek()) {
                totalCapitalGain += shareQ.peek() * (price - priceQ.poll());
                share -= shareQ.poll();
            //sells a portion of share
            } else {
                totalCapitalGain += share * (price - priceQ.peek());
                // removes the oldest shares from the queue and subtracts the number of shares sold 
                // and offers the updated value back into the queue.
                shareQ.offer(shareQ.poll() - share);
                for (int i = shareQ.size(); i > 1; i--)
                    shareQ.offer(shareQ.poll());
                share = 0;
            }
            System.out.println("Total Capital Gain / Loss: " + totalCapitalGain);
        }

    }

    public static void waiting(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

// Total capital gain or loss = number of shares sold on day j × (selling price per share−purchase price per share)