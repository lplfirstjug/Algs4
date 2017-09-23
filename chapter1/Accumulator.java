package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 15:43
  
  
 */

public class Accumulator {

    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    public String toString() {
        return "Mean " + N + " values: " + String.format("%7.5f", mean());
    }
}
