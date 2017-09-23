package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 11:08

  1.1.19
  斐波那契额数列更好的实现，
  使用数组保存已经计算过的值
 */

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci {

    private static long fib(int N) {
        if (N < 2) return N;
        return fib(N - 1) + fib(N - 2);
    }

    private static void fib2(long[] N) {
        N[0] = 0;
        N[1] = 1;

        for (int i = 2; i < N.length; i++) {
            N[i] = N[i - 1] + N[i - 2];
        }
    }

    public static void main(String[] args) {
        int lo = 41;
        int hi = 46;

        long[] N = new long[hi];
        fib2(N);

        for (int i = lo; i < hi; i++) {
            // StdOut.println(i+" " + fib(i));
            StdOut.println(i + " " + N[i]);
        }
    }
}
