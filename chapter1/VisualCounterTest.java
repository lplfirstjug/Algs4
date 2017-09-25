package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/23
  TIME: 20:19

  VisualCounter 类实例。
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounterTest {

    public static void main(String[] args) {

        VisualCounter c = new VisualCounter(1000, 500);

        for (int i = 0; i < 1000; i++) {
            if (StdRandom.bernoulli(0.6)) {
                c.increment();
            } else {
                c.decrease();
            }
        }
        StdOut.println(c);
    }
}
