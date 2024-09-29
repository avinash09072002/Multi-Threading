package Multi_Threading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class Execute implements Runnable {
    @Override
    public void run() {
        // Print the name of the current thread
        System.out.println("Executing on thread: " + Thread.currentThread().getName());

        for (int i = 1; i <= 100; i++) {
            System.out.println("hi - " + i + " on thread: " + Thread.currentThread().getName());
        }
    }
}

public class A5_My_Executors {
    public static void main(String[] args) {
        Runnable runnable = new Execute();

        // Create an Executor instance
        Executor service = Executors.newSingleThreadExecutor();

        // Submit the runnable to the executor
        service.execute(runnable);
    }
}
