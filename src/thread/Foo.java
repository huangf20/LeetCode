package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给你一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Foo {

    private AtomicInteger flag = new AtomicInteger(0);

    public Foo() {

    }

    public  void  first(Runnable printFirst) throws InterruptedException {

        while (flag.get() != 0);
        printFirst.run();
        flag.incrementAndGet();
    }

    public  void second(Runnable printSecond) throws InterruptedException {

        while (flag.get() != 1);

        printSecond.run();
        flag.incrementAndGet();
    }

    public  void third(Runnable printThird) throws InterruptedException {
        while (flag.get() != 2);
        printThird.run();
        flag.getAndSet(0);
    }


    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    foo.first(()-> System.out.println("A"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    foo.third(()-> System.out.println("C"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    foo.second(()-> System.out.println("B"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
