package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 10:59

  计算标准输入的平均值。

  % java Average
  please input:
  10.0
  2.0
  0.0
  <ctrl-z>
  Average is 4.00000

  % java Average < tinyW.txt

  % java RandomSeq 1000 100.0 200.0 | java Average
  150.49255

 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class Average {

    public static void main(String[] args) {
        double sum = 0.0;
        int cnt = 0;

        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            cnt++;
        }

        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
