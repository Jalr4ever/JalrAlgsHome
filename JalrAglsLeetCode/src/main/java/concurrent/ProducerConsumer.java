package main.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: JalrAlgsBin
 * @description: 使用阻塞队列解决生产者消费者问题
 * <p>
 * Created by jalr on 2019/8/1.
 */

class Producer extends Thread {
    BlockingQueue<String> buffer;

    public Producer(BlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            this.buffer.put("product");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producer is producing...");
    }
}

class Consumer extends Thread {
    BlockingQueue<String> buffer;

    public Consumer(BlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            this.buffer.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Consumer is consuming...");
    }
}

class ProducerConsumerDemo {
    public static void main(String[] args) {
        BlockingQueue<String> buffer = new ArrayBlockingQueue<>(5);
        for (int i = 0; i < 6; i++) {
            new Producer(buffer).start();
        }
        for (int i = 0; i < 8; i++) {
            new Consumer(buffer).start();
        }
        for (int i = 0; i < 2; i++) {
            new Producer(buffer).start();
        }
    }
}




