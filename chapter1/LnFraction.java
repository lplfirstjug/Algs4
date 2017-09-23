package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 11:12

  1.1.14
  int lg2(int)
    接受一个整型参数 N，返回不大于 Log2(N) 的最大整数。

  1.1.20
  double ln_prod(int)
    使用递归计算 ln(N!) 的值。

 */

import edu.princeton.cs.algs4.StdOut;

public class LnFraction {

    private static int lg2(int N) {
        int cnt = 0;
        for (int i = 0; N > 1.0; N /= 2) {
            cnt++;
        }
        return cnt;
    }

    private static double ln_prod(int N) {
        if (N <= 1) {
            return 0.0;
        }
        return Math.log(N) + ln_prod(N - 1);
    }

    private static void show_lg2() {
        int[] Ns = {1, 2, 4, 6, 8, 31, 33};

        for (int N : Ns) {
            StdOut.printf("lg2(%d) = %d\n", N, lg2(N));
        }
    }

    private static void show_ln_prod() {
        int[] Ns = {1, 2, 3, 4, 7};

        for (int N : Ns) {
            StdOut.printf("ln(%d!) = %4.4f\n", N, ln_prod((N)));
        }
    }

    public static void main(String[] args) {
            show_lg2();
            show_ln_prod();
    }
}
