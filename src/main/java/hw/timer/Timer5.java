package hw.timer;

public class Timer5 implements Runnable {
    private Timer timer;

    public Timer5(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        synchronized (timer) {
            while (true) {
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int time = timer.getTime();
                if (time % 5 == 0) {
                    System.out.print("\n5 Second Message\n");
                }
                if (time == 40) {
                    break;
                }
            }
        }
    }
}
