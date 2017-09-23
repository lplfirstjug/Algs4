package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 13:12

  1.1.31 随机连接
  从命令行接受一个整数 N 和一个浮点数 p(0~1)，在一个圆上画出间距相等的 N 个点。
  然后对每对点按照概率 p 连线。
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class RandomAccess {

    private static void draw_circle(double x, double y, double r, int N, double[][] a) {
        StdDraw.setXscale(0, x * 2);
        StdDraw.setYscale(0, y * 2);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.circle(x, y, r);
        for (int i = 0; i < N; i++) {
            StdDraw.setPenRadius(0.05);
            StdDraw.setPenColor(StdDraw.BLACK);
            double m = 50 - 50 * Math.cos(2 * Math.PI * i / N);
            double n = 50 + 50 * Math.sin(2 * Math.PI * i / N);
            StdDraw.point(m, n);
            a[i][0] = m;
            a[i][1] = n;
        }
    }

    private static void random_line(double x, double y, double p, double[][] a) {
        StdDraw.setXscale(0, x * 2);
        StdDraw.setYscale(0, y * 2);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (StdRandom.bernoulli(p))
                    StdDraw.line(a[i][0], a[i][1], a[j][0], a[j][1]);
            }
        }
    }

    public static void main(String[] args) {
        double x = 50;
        double y = 50;
        double r = 50;

        try {
            int N = Integer.parseInt(args[0]);
            double p = Double.parseDouble(args[1]);

            double[][] a = new double[N][2];
            //画圆/描点
            draw_circle(x, y, r, N, a);
            //画线
            random_line(x, y, p, a);
            random_line(x, y, p, a);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "需要输入两个参数，点的个数（整型），任意两点间连线的概率（浮点型）。");
        }
    }
}
