package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 13:08
  
  1.1.30 数组练习
  创建 N*N 的布尔数组，当 i,j 互质时，
  该位置上的元素为 true，否则为 false。
 */

import edu.princeton.cs.algs4.StdOut;


public class NumMatrix {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static void num_matrix(boolean[][] a, int N) {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                a[i][j] = NumMatrix.gcd(i, j) != 1;
            }
        }
    }

    public static void main(String[] args) {
        int N = 6;
        boolean[][] a = new boolean[N][N];

        num_matrix(a, N);

        for (int i = 1; i < N; i++) {
            StdOut.print(i + "\t\t");
        }
        StdOut.println();

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                StdOut.print(a[i][j] + "\t");
            }
            StdOut.println(i);
        }
    }
}
