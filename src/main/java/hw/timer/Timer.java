package hw.timer;

import static java.lang.Thread.sleep;

public class Timer implements Runnable {
    private volatile int time;
    private volatile boolean flag;

    @Override
    public void run() {
        while (time < 40) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(time + " ");
            setTime(time + 1);
        }
    }

    public synchronized void setTime(int time) {
        flag = true;
        this.time = time;
        flag = false;
        notifyAll();
    }

    public synchronized int getTime() {
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return time;
    }
}
