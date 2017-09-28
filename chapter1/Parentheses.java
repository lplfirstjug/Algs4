package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/27
  TIME: 20:56

 */

import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    private static boolean parentheses(String brackets) {
        Stack<Character> s = new Stack<>();
        String lft_bracket = "([{";
        String rgt_bracket = ")]}";
        for (int i = 0; i < brackets.length(); i++) {
            char tmp = brackets.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                s.push(tmp);
            } else {
                char lft_tmp = s.pop();
                if (lft_bracket.indexOf(lft_tmp) != rgt_bracket.indexOf(tmp)) {
                    return false;
                }
                /*
                else if(tmp==']' && lft_tmp!='['){
                    return false;
                    //s.push(lft_tmp);
                }
                */
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        StdOut.println(parentheses("[()]{}{[()()]()}"));
        StdOut.println(parentheses("[(])"));
    }
}
