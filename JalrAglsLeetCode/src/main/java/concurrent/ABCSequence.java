package main.java.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @program: JalrAlgsBin
 * @description: Created by jalr on 2019/8/22.
 */

class ABCT1 extends Thread {

    private Semaphore smphr1;
    private Semaphore smphr2;

    public ABCT1(Semaphore s1, Semaphore s2) {
        this.smphr1 = s1;
        this.smphr2 = s2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                smphr1.acquire();
                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                smphr2.release();
            }
        }

    }
}

class ABCT2 extends Thread {
    private Semaphore smphr3;
    private Semaphore smphr2;

    public ABCT2(Semaphore s2, Semaphore s3) {
        this.smphr2 = s2;
        this.smphr3 = s3;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                smphr2.acquire();
                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                smphr3.release();
            }
        }

    }
}

class T3 extends Thread {
    private Semaphore smphr1;
    private Semaphore smphr3;

    public T3(Semaphore s3, Semaphore s1) {
        this.smphr1 = s1;
        this.smphr3 = s3;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                smphr3.acquire();
                System.out.println("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                smphr1.release();
            }
        }
    }
}

class ABCSequence {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        new ABCT1(s1, s2).start();
        new ABCT2(s2, s3).start();
        new T3(s3, s1).start();

    }
}