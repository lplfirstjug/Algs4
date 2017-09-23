package chapter1;

/*
  PACKAGE: chapter1
  USER: wang hai
  DATE: 2017/9/23
  TIME: 15:14
  
  Counter类 计数器
      void  increment() 计数器自增 1
       int  tally()     计数器创建后被加 1 的次数
    String  toString()  对象的字符串表示
 */

public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return name + ": " + count;
    }
}
