package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/27
  TIME: 21:37



 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {

    private static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int __ = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; N < 100000; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.2f %5.2f\n", N, time, time / prev);
            prev = time;
        }
    }
}
