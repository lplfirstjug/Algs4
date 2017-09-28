package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 10:54
  Data files: data/tinyW.txt
              data/tinyT.txt
              data/largeW.txt
              data/largeT.txt

  二分查找，接受一个白名单文件（一列整数）作为参数，
  并将会过滤掉标准输入中存在于白名单中的条目，
  将不在白名单中的条目输出。

  % java BinarySearch tinyW.txt < tinyT.txt
  50
  99
  13

 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    private BinarySearch() {
    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }


    public static void main(String[] args) {

        // read the integers from a file
        try {
            In in = new In(args[0]);

            int[] whitelist = in.readAllInts();

            // sort the array
            Arrays.sort(whitelist);

            // read integer key from standard input; print if not in whitelist
            while (!StdIn.isEmpty()) {
                int key = StdIn.readInt();
                if (BinarySearch.indexOf(whitelist, key) == -1)
                    StdOut.print(key + " ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "二分查找，接受一个白名单文件（一列整数）作为参数，\n" +
                            "并将会过滤掉标准输入中存在于白名单中的条目，\n" +
                            "将不在白名单中的条目输出。\n" +
                            "% java BinarySearch tinyW.txt < tinyT.txt");
        }
    }
}
