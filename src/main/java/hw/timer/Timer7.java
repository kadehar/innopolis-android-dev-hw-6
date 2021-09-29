package hw.timer;

public class Timer7 implements Runnable {
    private Timer timer;

    public Timer7(Timer timer) {
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
                if (time % 7 == 0) {
                    System.out.print("\n7 Second Message\n");
                }
                if (time == 40) {
                    break;
                }
            }
        }
    }
}
