package hw.blockingqueue;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        HashMap<String, Long> frequencyMap = queue
                .stream()
                .collect(groupingBy(identity(),
                        HashMap::new,
                        counting()));
        AtomicLong count = new AtomicLong();

        frequencyMap
                .entrySet()
                .stream()
                .sorted(((o1, o2) -> o2.getValue()
                        .compareTo(o1.getValue())))
                .forEach(k -> {
                    System.out.printf("%s = %d %n", k.getKey(), k.getValue());
                    count.getAndAdd(k.getValue());
                });
        System.out.println("TOTAL: " + count);
    }
}
