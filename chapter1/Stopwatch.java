package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/26
  TIME: 10:56
  
  
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
