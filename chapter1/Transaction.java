package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/25
  TIME: 15:59
  
  
 */

import edu.princeton.cs.algs4.StdOut;

public class Transaction {

    private final String who;
    private final SmartDate data;
    private final double amount;

    private Transaction(String who, SmartDate data, double amount) {
        this.who = who;
        this.data = data;
        this.amount = amount;
    }

    public static void main(String[] args) {
        SmartDate d1 = new SmartDate(12, 12, 2000);
        SmartDate d2 = new SmartDate(12, 12, 2000);

        Transaction t1 = new Transaction("Ada", d1, 10.0);
        StdOut.println(t1);
        Transaction t2 = new Transaction("Ada", d2, 10.0);
        StdOut.println(t1.equals(t2));
        StdOut.println(t2.equals(d1));
    }

    public String who() {
        return this.who;
    }

    public SmartDate when() {
        return this.data;
    }

    public double amount() {
        return this.amount;
    }

    public String toString() {
        return this.who + " " + this.data.toString() + " " + this.amount;
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        return this.amount == that.amount && this.who.equals(that.who) && this.data.equals(that.data);
    }
}
