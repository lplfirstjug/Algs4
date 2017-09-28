package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/26
  TIME: 10:47

  1.4.2.1
  统计输入流中所有和为 0 整数三元组的数目
  
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println(count + " triples  " + timer.elapsedTime() + " seconds");
    }
}
