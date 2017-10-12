package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/27
  TIME: 11:02

  Josephus问题
    在这个古老的问题中 N 个身陷绝境的人一致同意通过以下方式减少生存人数。
    他们围坐成一圈（位置记为 0 到 N-1）并从第一个人开始报数，报到 M 的人会被杀死，
    直到最后一个人留下来。传说中 Josephus 找到了不会被杀死的位置。

    编写一个 Queue 的用例 Josephus，从命令行接受 N 和 M 并打印出人们被杀死的顺序
    （这也将显示Josephus在圈中的位置）。

  %java〕JosephusProblem 7 2
  1 3 5 0 4 2 6

 */

import edu.princeton.cs.algs4.StdOut;

public class JosephusProblem {

    private static void josephus(int N, int M) {
        Queue<Integer> q = new Queue<>();
        Queue<Integer> rest = new Queue<>();

        for (int i = 0; i < N; i++) q.enqueue(i);

        int rest_count = N;
        int index = 1;
        while (rest_count > 0) {
            if (q.isEmpty()) {
                for (int i : rest) q.enqueue(rest.dequeue());
            } else {
                while (true) {
                    if (q.isEmpty()) break;
                    else if (index % M != 0) rest.enqueue(q.dequeue());
                    else {
                        StdOut.print(q.dequeue() + " ");
                        rest_count--;
                    }
                    index++;
                }
            }
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        josephus(N, M);
    }
}
