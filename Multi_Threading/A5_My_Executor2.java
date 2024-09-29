package Multi_Threading;



import java.util.concurrent.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Execute1 implements Runnable {
    @Override
    public void run() {
        // Print the name of the current thread
        System.out.println("Executing on thread: " + Thread.currentThread().getName());

        for (int i = 1; i <= 100; i++) {
            System.out.println("hi - " + i + " on thread: " + Thread.currentThread().getName());
        }
    }
}

public class A5_My_Executor2 {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);       // just change it to Excecutor

        // Create multiple Runnable tasks
        Runnable task1 = new Execute1();
        Runnable task2 = new Execute1();
        Runnable task3 = new Execute1();

        // Submit the tasks to the executor service
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
  executorService.shutdown();

        // Shutdown the executor service

    }
}
