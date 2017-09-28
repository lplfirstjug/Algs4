package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/27
  TIME: 09:40

 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    private static int random_bag_test(int n) {
        RandomBag<Integer> b = new RandomBag<>();
        for (int i = 0; i < n; i++) {
            b.add(i);
        }
        for (int i : b) {
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] count = new int[3];
        for (int i = 0; i < 10000; i++) {
            count[random_bag_test(3)]++;
        }
        for (int i : count) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    private void shuffle() {
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            Item tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N] = item;
        N++;
        shuffle();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            i--;
            return a[i];
        }

        @Override
        public void remove() {
        }
    }
}
