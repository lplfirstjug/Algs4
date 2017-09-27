package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/23
  TIME: 21:42

  1.3.2.2 泛型

  FixedCapacityStack 类  泛型定容栈
            FixedCapacityStack(int)     创建一个固定容量的空栈
      void  Push(Item)                  添加一个元素
      Item  pop()                       删除最近添加的元素
   boolean  isEmpty()                   栈是否为空
       int  size()                      栈中的元素数量

  创建泛型数组时的类型转换。

 */

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> implements FixedCapacityStackTest.FixedStack {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
        // a= new Item[cap];
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<>(100);
        String[] str = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        for (String item : str) {
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("\n" + s.size() + " left on stack.");
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Object item) {
        a[N] = (Item) item; // 泛型数组
        N++;
    }

    public Item pop() {
        N--;
        return a[N];
    }
}
