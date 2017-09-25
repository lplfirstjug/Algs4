package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 PACKAGE: chapter1
 USER: wang hai
 DATE: 2017/9/22
 TIME: 15:58

 Accumulator 类的用例
    统计随机数
 VisualAccumulator 类的用例
    统计随机数并可视化

 */

public class AccumulatorTest {

    private static void test_accumulator(int T) {
        Accumulator a = new Accumulator();
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.uniform());
        }
        StdOut.println(a);
    }

    public static void main(String[] args) {
        test_accumulator(1000);
    }
}
