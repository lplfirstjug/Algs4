package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/24
  TIME: 13:56

 */

import edu.princeton.cs.algs4.StdOut;

public class StackTest {

    public static void stack_test(Stack st) {
        String[] str = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (!s.equals("-")) {
                st.push(s);
            } else {
                StdOut.print(st.pop() + " ");
            }
        }
        StdOut.println("\n" + st.size() + " left on stack");
    }

    public static void main(String[] args) {
        Stack s_of_s = new FixedCapacityStackOfString(100);
        Stack<String> s_all = new FixedCapacityStack<String>(100);

        stack_test(s_of_s);
        stack_test(s_all);
    }

    /*
    public void stack_test(ResizingArrayStack st) {
        String[] str = {"to","be","or","not","to","-","be","-","-","that","-","-","-","is"};
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (!s.equals("-")){
                st.push(s);
            }
            else{
                StdOut.println(st.pop()+" ");
            }
        }
    }
    */

    public interface Stack<Item> {
        void push(Item s);

        Item pop();

        int size();
    }
}
