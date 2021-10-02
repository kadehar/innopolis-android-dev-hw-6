package hw;

import hw.blockingqueue.Consumer;
import hw.blockingqueue.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(producer);
        executor.submit(consumer);

        executor.shutdown();
    }
}
