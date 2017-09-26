package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 13:50

  1.1.39 随机匹配
  从命令行接受一个整型参数 T，并会分别针对 10^3、10^4、10^5 和 10^6将以下实验运行 T 遍：
  生成两个大小相同的随机6位正整数数组，并找出同时存在于两个数组中的整数的数量。
  打印一个表格，对于每个 N 给出 T 次实验中该数量的平均值。

 */

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;


public class SameProb {

    private static int cnt_same(int N, int hi) {
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(hi);
            b[i] = StdRandom.uniform(hi);
        }

        Arrays.sort(a);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.indexOf(a, b[i]) != -1) {
                cnt++;
            }
        }
        return cnt;
    }


    private static double averageProb(int N, int T) {
        double prob = 0.0;
        for (int i = 0; i < T; i++) {
            prob += cnt_same(N, 2 * N);
        }
        return prob / T;
    }

    private static void showProb(int T) {
        int[] Ns = {1000, 10000, 100000, 1000000};
        for (int N : Ns) {
            StdOut.printf("%-9d %-9.2f\n", N, averageProb(N, T));
        }
    }

    public static void main(String[] args) {
        try {
            int T = Integer.parseInt(args[0]);
            showProb(T);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("需要输入一个参数，实验次数（整型）。");
        }
    }
}
