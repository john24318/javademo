package demo.java.util;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // 是否守护线程。若不存在非守护线程则自动结束程序，反之程序一直运行。
        Timer timer = new Timer();
        // schedule方法在排程时，默认采用Fixed-delay execution固定延迟执行的方式：如果这次的run方法在周期时间内执行完毕，则下次run就如期排程。
        // 如果这次run方法无法在周期时间内完成，则接下来的任务排定就会被拖延，等到上次任务完成后立即排定并执行。
        timer.schedule(new DateTask1(), 1000, 3000);
        timer.schedule(new DateTask2(), 2000, 3000);
        // 也可指定为Fix-rate Execution固定速率执行方式：如果这次的run方法在周期时间内执行完毕，则下次run就如期排程。如果这次的run方法无法在周期时间内完成，则接下来的任务排定不会被拖延，但真正的执行要等到上次任务完成后执行。
        /*
         * timer.scheduleAtFixedRate(new DateTask1(), 1000, 3000); timer.scheduleAtFixedRate(new DateTask2(), 1000, 3000);
         */

        System.out.println("现在时间：\t" + System.currentTimeMillis());

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }

        timer.cancel();
    }

}

class DateTask1 extends TimerTask {
    private int count = 0;

    @Override
    public void run() {
        System.out.println("任务1排定时间：\t" + scheduledExecutionTime());
        System.out.println("任务1执行时间：\t" + System.currentTimeMillis() + " count：" + (++count));
    }
}

class DateTask2 extends TimerTask {
    @Override
    public void run() {
        // scheduledExecutionTime方法取得TimerTask的的排定时间
        System.out.println("任务2排定时间：\t" + scheduledExecutionTime());
        System.out.println("任务2执行时间：\t" + System.currentTimeMillis());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}