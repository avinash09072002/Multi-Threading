package Multi_Threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class A7_scheduleAtFixedRate {
    public static void main(String[] args) {
        // Create a ScheduledExecutorService with a single thread
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Define a task to be scheduled
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed at: " + System.currentTimeMillis());
            }
        };

        // Schedule the task to run every 3 seconds, with an initial delay of 2 seconds
        scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);

        // Keep the program running for a while to observe the scheduled task
        try {
            Thread.sleep(20000); // Keep the main thread alive for 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the scheduler
        scheduler.shutdown();
    }
}


