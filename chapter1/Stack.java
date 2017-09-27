package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/25
  TIME: 15:09

  Stack 类 后进先出队列，下压栈
    public class Stack<Item> implements Iterable<Item>
                Stack()         创建一个空栈
        void    push(Item)  添加一个元素
        Item    pop()       删除最近添加的元素
     boolean    isEmpty()   栈中的元素是否为空
         int    size()      栈中元素的数量
  
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private static Stack<String> copy(Stack<String> stack) {
        Stack<String> res = new Stack<>();
        for (String s : stack) {
            res.push(s);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] ns = {10, 20, 30, 40, 50};

        for (int n : ns) {
            stack.push(n);
        }

        for (int i : stack) {
            StdOut.print(i + " ");
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
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
