package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    private static boolean is_contains(Stack<Character> s, char item) {
        for (char c : s) {
            if (c == item) return true;
        }
        return false;
    }

    private static void remove_to_front(Stack<Character> s, char item) {
        Stack<Character> front = new Stack<>();

        for (char tmp = s.pop(); tmp != item; tmp = s.pop()) {
            front.push(tmp);
        }

        for (char c : front) {
            s.push(c);
        }
        s.push(item);
    }

    private static void move_to_front(Stack<Character> s, char[] item) {
        for (char c : item) {
            if (!is_contains(s, c)) {
                s.push(c);
            } else {
                remove_to_front(s, c);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        char[] chr = {'0', '0', '0', '0', '1', '2', '1', '3', '4', '4', '5'};
        move_to_front(s, chr);
        for (char c : s) {
            StdOut.print(c + " ");
        }
        StdOut.println();

    }
}
