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
        int N = stack.size();
        String[] tmp = new String[N];

        // 出现倒序！！！
        for (int i = 0; i < N; i++) {
            tmp[i] = stack.pop();
            res.push(tmp[i]);
        }
        for (int i = 0; i < N; i++) {
            stack.push(tmp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        String[] ns = {"10", "20", "30", "40", "50"};

        for (String n : ns) {
            s.push(n);
        }

        for (String n : ns) {
            StdOut.print(n + " ");
        }
        StdOut.println();

        Stack<String> s2 = copy(s);

        for (String i : s) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        for (String i : s2) {
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
