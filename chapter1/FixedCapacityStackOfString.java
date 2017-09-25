package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/23
  TIME: 21:24

  FixedCapacityStackOfString 类  定容字符串栈
            FixedCapacityStackOfString(int)     创建一个固定容量的空栈
      void  Push(Item)                          添加一个字符串
      Item  pop()                               删除最近添加的字符串
   boolean  isEmpty()                           栈是否为空
       int  size()                              栈中的字符串数量
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfString implements FixedCapacityStackTest.FixedStack {

    private String[] a;
    private int N;

    public FixedCapacityStackOfString(int cap) {
        a = new String[cap];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfString s;
        s = new FixedCapacityStackOfString(100);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isempty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("\n" + s.size() + " left on stack");
    }

    public boolean isempty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Object item) {
        a[N] = (String) item;
        N++;
    }

    public String pop() {
        N--;
        return a[N];
    }
}