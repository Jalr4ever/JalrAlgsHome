package main.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JalrAlgsBin
 * @description: 两个线程交替打印 1 - 100
 * <p>
 * Created by jalr on 2019/9/26.
 */
class T1 extends Thread {
    Lock lock;
    Condition c1;
    Condition c2;
    private AtomicInteger count;

    public T1(Lock lock, Condition c1, Condition c2, AtomicInteger count) {
        this.lock = lock;
        this.c1 = c1;
        this.c2 = c2;
        this.count = count;
    }

    public void run() {
        lock.lock();
        try {
            T2.working(count, c2, c1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class T2 extends Thread {
    private Lock lock;
    private Condition c1;
    private Condition c2;
    private AtomicInteger count;

    public T2(Lock lock, Condition c1, Condition c2, AtomicInteger count) {
        this.lock = lock;
        this.c1 = c1;
        this.c2 = c2;
        this.count = count;
    }

    public void run() {
        lock.lock();
        try {
            working(count, c1, c2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (count.get() == 101) {
                c1.signal(); //保证先把自己锁的线程一定能结束
            }
            lock.unlock();
        }
    }

    public static void working(AtomicInteger count, Condition c1, Condition c2) throws InterruptedException {
        while (count.get() <= 100) {
            System.out.println(count);
            count.incrementAndGet();
            c1.signal();
            c2.await();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        AtomicInteger count = new AtomicInteger(0);
        T1 t1 = new T1(lock, c1, c2, count);
        T2 t2 = new T2(lock, c1, c2, count);
        t1.start();
        t2.start();

    }
}
