package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/25
  TIME: 14:51
  
  
 */

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfInt {

    private int[] a;
    private int N;

    public FixedCapacityStackOfInt(int cap) {
        a = new int[cap];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfInt s;
        s = new FixedCapacityStackOfInt(100);

        int[] ints = {2, 4, 1, -3, 5, -2, 6, -1, -4, -2, 0};
        for (int i : ints) {
            if (i < 0) {
                StdOut.println(s.pop() + " ");
            } else {
                s.push(i);
            }
        }
        StdOut.println("\n" + s.size() + " left on stack.");

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(int item) {
        a[N] = item;
        N++;
    }

    public int pop() {
        N--;
        return a[N];
    }
}
