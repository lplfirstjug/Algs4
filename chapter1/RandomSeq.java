package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 11:04

  输出多个浮点型随机数，接受三个参数。
  第一个整形参数确定输出随机数的个数，
  第二个，第三个浮点型参数确定随机数的上下界。

  % java RandomSeq 5 100.0 200.0
  123.43
  153.13
  144.38
  155.18
  104.02

  % java RandomSeq 1000 100.0 200.0 | java Average
  150.49255

 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSeq {

    private static void randomSeq(int N, double lo, double hi) {
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }

    public static void main(String[] args) {
        try {
            int N = Integer.parseInt(args[0]);
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);
            RandomSeq.randomSeq(N, lo, hi);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "需要输入三个参数，随机数个数（整型），下限（浮点型），上限 （浮点型）。\n" + "可以和 Average 配合使用。");
        }
    }
}
