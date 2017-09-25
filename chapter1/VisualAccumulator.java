package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/22
  TIME: 15:49

  VisualAccumulator类  可视化累加器
                    VisualAccumulator()     创建一个累加器
            void    addDataValue(double)    添加一个新的数据值
          double    mean()                  所有数据的平均值
          String    toString()              对象的字符串表示
  * 该实现不保存数据的值

 */

import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator {

    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.point(N, total / N);
    }

    public double mean() {
        return total / N;
    }

    @Override
    public String toString() {
        return "Mean " + N + " values: " + String.format("%7.5f", mean());
    }

}
