package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/25
  TIME: 15:16

  Queue 类 先进先出队列
    public class Queue<Item> implements Iterable<Item>
                Queue()         创建一个空队列
        void    enqueue(Item)   添加一个元素
        Item    dequeue()       删除最近添加的元素
     boolean    isEmpty()       队列中的元素是否为空
         int    size()          队列中元素的数量
  
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        int[] ns = {10, 20, 30, 40, 50};

        for (int n : ns) {
            q.enqueue(n);
        }

        int N = q.size();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = q.dequeue();
        }

        for (int n : a) {
            StdOut.print(n + " ");
        }

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node old_last = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else old_last.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
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
