package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/27
  TIME: 10:27

 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    private static int random_queue_test() {
        RandomQueue<Integer> q = new RandomQueue<>();
        for (int i = 0; i < 5; i++) {
            q.enqueue(i);
        }
        return q.dequeue();
    }

    public static void main(String[] args) {
        int[] count = new int[5];
        for (int i = 0; i < 1000; i++) {
            count[random_queue_test()]++;
        }
        for (int i : count) {
            StdOut.print(i + " ");
        }
        StdOut.println();

    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N] = item;
        N++;
    }

    private void shuffle_last() {
        int r = StdRandom.uniform(N);
        if (r != N - 1) {
            Item tmp = a[N - 1];
            a[N - 1] = a[r];
            a[r] = tmp;
        }
    }

    public Item dequeue() {
        shuffle_last();
        N--;
        Item item = a[N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Item sample() {
        shuffle_last();
        return a[N - 1];
    }
}
