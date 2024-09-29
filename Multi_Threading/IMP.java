package Multi_Threading;
class MyClass {
    public void method1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Method1 - Step " + i);
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void method2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Method2 - Step " + i);
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


public class IMP {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                myClass.method1();
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                myClass.method2();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
