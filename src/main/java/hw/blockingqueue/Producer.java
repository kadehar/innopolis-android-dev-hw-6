package hw.blockingqueue;

import hw.parser.Parser;
import hw.parser.Roots;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private Parser parser = new Parser();
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        File file = new File("src/main/resources/voyna.txt");
        ArrayList<String> list = parser.parse(file);
        list.forEach(str -> {
            if (str.matches(Roots.SUFFERING.pattern())) {
                try {
                    queue.put(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
