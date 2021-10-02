package hw;

import hw.timer.Timer;
import hw.timer.Timer5;
import hw.timer.Timer7;

public class Timers {
    public static void main(String[] args) {
        Timer timer = new Timer();
        new Thread(timer).start();

        Timer5 timer5 = new Timer5(timer);
        new Thread(timer5).start();

        Timer7 timer7 = new Timer7(timer);
        new Thread(timer7).start();
    }
}
