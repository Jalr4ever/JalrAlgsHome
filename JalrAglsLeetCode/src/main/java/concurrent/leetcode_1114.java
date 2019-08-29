package main.java.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @program: JalrAlgsBin
 * @description: 按序打印
 * <p>
 * Created by jalr on 2019/8/22.
 */
class Foo {
    public Foo() {

    }

    Semaphore smphr1 = new Semaphore(1);
    Semaphore smphr2 = new Semaphore(0);
    Semaphore smphr3 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            smphr1.acquire();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        } finally {
            smphr2.release();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            smphr2.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        } finally {
            smphr3.release();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            smphr3.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            smphr1.release();
        }

    }
}
