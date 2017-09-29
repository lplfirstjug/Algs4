package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/26
  TIME: 20:40

 */

import edu.princeton.cs.algs4.StdOut;

public class Evaluate {

    private static void evaluate(String[] strs) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (String s : strs) {
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case "+":
                            v = vals.pop() + v;
                            break;
                        case "-":
                            v = vals.pop() - v;
                            break;
                        case "*":
                            v = vals.pop() * v;
                            break;
                        case "/":
                            v = vals.pop() / v;
                            break;
                    }
                    vals.push(v);
                    break;
                default:
                    vals.push(Double.parseDouble(s));
                    break;
            }
        }
        StdOut.println(vals.pop());
    }

    /*
    private static String reverse(String str){
        String res= "";
        for (int i = 0; i < str.length(); i++) {
            res=str.substring(i,i+1)+res;
        }
        return res;
    }
    */

    private static void infix_to_postfix(String[] strs) {

    }

    private static void left_bracket(String[] strs) {
        Stack<String> out = new Stack<>();
        // String[] sub_out = new String[4];

        for (String s : strs) {
            out.push(s);
            if (s.equals(")")) {
                /*
                for (int i = 3; i >= 0; i--) {
                    sub_out[i]=out.pop();
                }
                String tmp="";
                for (int i = 0; i < 4; i++) {
                    tmp += sub_out[i];
                }
                */
                String tmp = "";
                for (int i = 0; i < 4; i++) {
                    tmp = out.pop() + tmp;
                }
                out.push("(" + tmp);
            }
        }
        StdOut.println(out.pop());
    }

    public static void main(String[] args) {
        String eva = "((1+0)+((2+3)*(4*5)))";
        String[] formula_lat = eva.split("");
        evaluate(formula_lat);
        String[] eva_left_bracket = eva.replace("(", "").split("");
        left_bracket(eva_left_bracket);
    }
}
