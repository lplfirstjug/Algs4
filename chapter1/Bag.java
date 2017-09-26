package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/26
  TIME: 15:20
  
  
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        double[] ns = {100, 99, 101, 120, 98, 107, 109, 81, 101, 90};

        for (double n : ns) {
            numbers.add(n);
        }
        int N = numbers.size();

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
