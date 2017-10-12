package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/24
  TIME: 10:09

 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

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

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N] = item;
        N++;
    }

    public Item pop() {
        N--;
        Item item = a[N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            i--;
            return a[i];
        }

        public void remove() {
        }
    }

    private static double time_test(int N,int T){
        Stopwatch tm = new Stopwatch();
        ResizingArrayStack<Integer> rs = new ResizingArrayStack<>();
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N ; j++){
                rs.push(j);
            }
        }
        return tm.elapsedTime();
    }

    private static void show_time(int L){
        StdDraw.setXscale(0,L);
        StdDraw.setYscale(0,0.15);
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(StdDraw.BOOK_RED);

        for (int i = 1; i <= L ; i++) {
            StdDraw.point(i,time_test(i,100000));
        }
    }

    public static void main(String[] args){
        VisualAccumulator va = new VisualAccumulator(200,0.5);
        for (int i = 1; i <= 200 ; i++) {
            va.addDataValue(time_test(i,100000));
        }
    }
}
