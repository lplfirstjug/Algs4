package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/25
  TIME: 15:09
  
  
 */

public class Stack<Item> {

    private Node first;
    private int N;

    public static void main(String[] args) {

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

    private class Node {
        Item item;
        Node next;
    }
}
