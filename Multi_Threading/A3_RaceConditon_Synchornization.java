

package Multi_Threading;

class Counter {
    int count = 0;

    // Method to increment the counter                                   //  Sychronized method
//    public synchronized void    increment() {
//        count++;
//    }
//    // or

    public void increment(){                                           // Sychronized Block
        synchronized (this){
            count++;
        }
    }
}

public class A3_RaceConditon_Synchornization {
    public static void main(String[] args) {
        Counter c = new Counter();

        // Define two Runnable tasks that increment the counter
        Runnable task1 = () -> {
            for (int i = 1; i <= 100; i++) {
                c.increment();
            }
        };

        Runnable task2 = () -> {
            for (int i = 1; i <= 100; i++) {
                c.increment();
            }
        };

        // Create and start two threads
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        // Wait for both threads to complete
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value of count
        System.out.println("Final count: " + c.count); // Expected: 2000, but may be less due to race condition
    }
}
