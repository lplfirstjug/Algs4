package chapter1;

/*

  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/26
  TIME: 20:40

  我们要学习的另一个栈用例同时也是展示泛型的应用的一个经典例子。
  计算算术表达式的值

  从标准输人得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
  例如，给定输入：
    1+2)*3-4)*5-6)))
  你的程序应该输出：
    ((1+2)*((3-4)*(5-6)))

  过滤器函数 InfixToPostfix，将算术表达式由中序表达式转为后序表达式。

  EvaluatePostfix 函数，从标准输人中得到一个后序表达式，求值并打印结果。


*/

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Evaluate {

    /*
    private static void evaluate_postfix(String[] strs) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (String s : strs) {
            if (s.equals("(")) { }
            else if (s.matches("[\\+\\-\\/*]")) {
                ops.push(s);
            } else if (s.equals(")")) {
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
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
    */

    private static void evaluate(String[] strs) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (String s : strs) {
            if (s.equals("(")) { }
            else if (s.matches("[\\+\\-\\*/]")) {
                ops.push(s);
            } else if (s.equals(")")) {
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

            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }

    private static String infix_to_postfix(String[] strs) {
        Stack<String> out = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (String s:strs){
            if (s.matches("\\+|-|\\*|/"))
                ops.push(s);
            else if (!s.equals(")"))
                out.push(s);
            else {
                String tmp = ops.pop()+s;
                for (String a = out.pop();!a.equals("(");a=out.pop()){
                    tmp = a+tmp;
                }
                out.push("("+tmp);
            }
        }
        return out.pop();
    }

    // 添加左括号
    private static String left_bracket(String[] strs) {
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
        return out.pop();
    }

    private static void evaluate_test(){
        String eva = "((1+0)+((2+3)*(4*5)))";
        String[] formula_lat = eva.split("");
        evaluate(formula_lat);
        StdOut.println(left_bracket(eva.replace("(","").split("")).equals(eva));
        String eva_post = infix_to_postfix(formula_lat);
        StdOut.println(eva_post);
        evaluate(eva_post.split(""));
    }

    public static void main(String[] args) {
//        String eva2 = "((1+2)*3)";
//        String[] formula_lat2 = eva2.split("");
//        infix_to_postfix(formula_lat2);
        evaluate_test();
    }
}
