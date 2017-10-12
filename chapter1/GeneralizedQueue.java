package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueue<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty(){
        return first==null;
    }

    private void insert(Item x){
        Node old_last = last;
        last  = new Node();
        last.item = x;
        last.next = null;
        if (isEmpty()) first=last;
        else old_last.next = last;
        N++;
    }

    private void get_n(int K){
        Node now = first;
        for (int i = 0; i < K; i++) {
            now=now.next;
        }
        StdOut.println(now.item);
    }

    private Item delete(int K){
        if (K==0) {
            Item item = first.item;
            first=first.next;
            N--;
            return item;
        }
        Node now = first;
        for (int i = 1; i < K; i++) {
            now=now.next;
        }
        Item item= now.next.item;
        now.next = now.next.next;
        N--;
        return item;
    }

    public static void main(String[] args){
        GeneralizedQueue<Integer> q = new GeneralizedQueue<>();
        for (int i = 0; i < 5; i++) {
            q.insert(-i);
        }

        StdOut.println(q.delete(3));

        for (int i = 0; i < 4; i++) {
            q.get_n(i);
        }
        StdOut.println("q has "+q.N+" elements.");
    }
}
