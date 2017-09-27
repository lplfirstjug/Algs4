package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/26
  TIME: 23:54

 */

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayDeque<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> d = new ResizingArrayDeque<>();
        d.pushLeft(1);
        d.pushRight(2);
        d.pushLeft(-1);
        d.pushLeft(-2);
        d.printDeque();
        StdOut.println(d.popRight());
        StdOut.println(d.popRight());
        StdOut.println(d.popLeft());
        d.printDeque();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void pushRight(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N] = item;
        N++;
    }

    public Item popRight() {
        N--;
        Item item = a[N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public void pushLeft(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        for (int i = N - 1; i >= 0; i--) {
            a[i + 1] = a[i];
        }
        a[0] = item;
        N++;
    }

    public Item popLeft() {
        Item item = a[0];
        for (int i = 1; i < N; i++) {
            a[i - 1] = a[i];
        }
        N--;
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void printDeque() {
        for (Item item : a) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }
}
