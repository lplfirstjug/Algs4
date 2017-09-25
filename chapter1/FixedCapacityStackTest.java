package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/24
  TIME: 13:56

 */

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackTest {

    public static void stack_test(FixedStack st) {
        String[] str = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        for (String s : str) {
            if (!s.equals("-")) {
                st.push(s);
            } else {
                StdOut.print(st.pop() + " ");
            }
        }
        StdOut.println("\n" + st.size() + " left on stack");
    }

    public static void main(String[] args) {
        FixedStack s_of_s = new FixedCapacityStackOfString(100);
        FixedStack<String> s_all = new FixedCapacityStack<String>(100);

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

    public interface FixedStack<Item> {
        void push(Item s);

        Item pop();

        int size();
    }
}
