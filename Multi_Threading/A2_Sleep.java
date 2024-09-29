package Multi_Threading;

class B1 extends Thread {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("from B");
            try {
                Thread.sleep(500); // Adding sleep to make the output readable
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        }
    }
}

public class A2_Sleep {
    public static void main(String[] args) {
        // Create and start the thread t1
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("hi");
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted.");
                    }
                }
            }
        };

        // Create an instance of B1 and start it
        B1 obj = new B1();
        obj.start(); // Start the thread

        // Start the thread t1
        t1.start();
    }
}
