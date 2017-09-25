package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 15:43

  Accumulator类 累加器
                Accumulator()           创建一个累加器
        void    addDataValue(double)    添加一个新的数据值
      double    mean()                  所有数据的平均值
      String    toString()              对象的字符串表示
  * 该实现不保存数据的值

 */

public class Accumulator {

    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    public String toString() {
        return "Mean " + N + " values: " + String.format("%7.5f", mean());
    }
}
