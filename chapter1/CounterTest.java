package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 15:16
  
  Counter 类的测试和用例
  filps
    模拟掷硬币
  rools
    模拟掷色子
  
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class CounterTest {

    private static void counter_test() {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        tails.increment();
        tails.increment();

        StdOut.println(heads + " " + tails);
        StdOut.println(heads.tally() + tails.tally());
    }

    private static void flips(int T) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        StdOut.println(heads + "\t" + tails);
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));
    }

    private static void rolls(int T) {
        int SIDES = 6;
        Counter[] rolls = new Counter[SIDES + 1];
        for (int i = 0; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "'s");
        }
        for (int i = 0; i < T; i++) {
            int res = StdRandom.uniform(1, SIDES + 1);
            rolls[res].increment();
        }
        for (int i = 1; i < SIDES + 1; i++) {
            StdOut.println(rolls[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Counter 类测试");
        counter_test();
        StdOut.println();

        System.out.println("模拟掷硬币");
        flips(10000);
        StdOut.println();

        System.out.println("模拟掷色子");
        rolls(10000);
    }
}
