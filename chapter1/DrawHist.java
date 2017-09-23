package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 13:30

  1.1.31 直方图
  //TODO
  
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class DrawHist {

    private static double[] split(int N, double lo, double hi) {
        double[] spl = new double[N + 1];
        double wd = (hi - lo) / N;
        for (int i = 0; i <= N; i++) {
            spl[i] = wd * i + lo;
        }
        return spl;
    }

    private static int[] count(double[] x, double[] in) {
        int[] cnt = new int[x.length - 1];

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < x.length - 1; j++) {
                if ((x[j] <= in[i]) && (in[i] < x[j + 1])) {
                    cnt[j]++;
                }
            }
        }
        return cnt;
    }

    private static void draw_hist(int[] cnt, double lo, double hi) {
        int N = cnt.length;
        double lo_t = lo - (hi - lo) / (2 * N);

        StdDraw.setXscale(lo_t, hi);
        StdDraw.setYscale(0, StdStats.max(cnt) * 1.2);

        for (int i = 0; i < N; i++) {
            double x = lo + (hi - lo) * i / N;
            double y = cnt[i] / 2.0;
            double rw = (hi - lo) / (2 * N);
            double rh = cnt[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }


    public static void main(String[] args) {
        int N = 100;
        double lo = 5.0;
        double hi = 10.0;

        // 分割 (lo, hi) 为 N 份的线段 sp
        double[] sp = split(N, lo, hi);

        int point_n = 50000;
        double[] seq = new double[point_n];

        // 产生 point_n 个随机数
        for (int i = 0; i < point_n; i++) {
            seq[i] = StdRandom.uniform(lo, hi);
        }

        // 统计随机数组 seq 落在被分割的线段 sp 的数量
        int[] cnt = count(sp, seq);

        for (int i = 0; i < N; i++) {
            StdOut.print(cnt[i] + " ");
        }

        // 画出直方图
        draw_hist(cnt, lo, hi);
    }
}
