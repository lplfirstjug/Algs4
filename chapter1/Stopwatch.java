package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/26
  TIME: 10:56

  Stopwatch 类   计数器
            Stopwatch()     创建一个计时器
    double  e1apseTime()    返回对象创建以来所经过的时间

 */

public class Stopwatch {

    private final long start;

    public Stopwatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
