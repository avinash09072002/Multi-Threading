package Multi_Threading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class A11 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is executing");
            Thread.sleep(1000); // Simulate long-running task
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }
    }
}

public class A6_My_ShutdownNow {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService service = Executors.newFixedThreadPool(3);

        // Submit several tasks to the executor service
        for (int i = 0; i < 10; i++) {
            service.execute(new A11());
        }

        // Shutdown the executor service immediately
        List<Runnable> notExecutedTasks = service.shutdownNow();

        // Print out the tasks that were not executed
        System.out.println("Tasks that were not executed: " + notExecutedTasks.size());

        // Attempt to await termination of remaining tasks
        try {
            if (!service.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Executor did not terminate in the specified time.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Shutdown complete.");
    }
}

