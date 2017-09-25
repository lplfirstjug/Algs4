package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/23
  TIME: 19:37

  1.2.10


  VisualCounter类    可视化计数器
                    Counter(int, int)   创建一个可视化计数器，最大的操作次数，最大的绝对值
            void    increment()         计数器自增 1
            void    decrease()          计数器自减 1
             int    tally()             计数器创建自增，自减后的值
          String    toString()          对象的字符串表示

 */

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {

    private int count;
    private int op_cnt;

    public VisualCounter(int N, int max) {
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(.005);
    }

    private void change_var(int i) {
        op_cnt++;
        count += i;
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.point(op_cnt, count);
    }

    public void increment() {
        change_var(1);
    }

    public void decrease() {
        change_var(-1);
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return "Count: " + count;
    }
}
