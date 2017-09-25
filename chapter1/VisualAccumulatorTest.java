package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/25
  TIME: 22:13

 */

import edu.princeton.cs.algs4.StdRandom;

public class VisualAccumulatorTest {

    private static void test_visual_accumulator(int T) {
        VisualAccumulator va = new VisualAccumulator(T, 1.0);
        for (int i = 0; i < T; i++) {
            va.addDataValue(StdRandom.uniform());
        }
        System.out.println(va);
    }

    public static void main(String[] args) {
        test_visual_accumulator(1000);
    }
}
