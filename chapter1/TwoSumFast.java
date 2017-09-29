package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/28
  TIME: 10:36
  Data files: 1Kints.txt
              2Kints.txt
              4Kints.txt
              8Kints.txt

  1.4.5.1
  2-sum 问题的线性对数级别解法
  
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int count_faster(int[] a) {
        int cnt = 0;
        int i = 0;
        int j = a.length - 1;
        while (i != j) {
            if (a[i] + a[j] > 0) j--;
            else if (a[i] + a[j] < 0) i++;
            else {
                cnt++;
                i++;
                // 重复数字
                if (a[i - 1] != a[i]) j--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
        Arrays.sort(a);
        StdOut.println(count_faster(a));
    }
}
