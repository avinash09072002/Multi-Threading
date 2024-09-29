package Multi_Threading;

class Earning implements Runnable{
    int total=0;
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                total = total + 100;
            }
            this.notify();
        }

    }
}

public class A8_Wait_and_Notify {

    public static void main(String[] args) throws InterruptedException {
        Earning runnable= new Earning();
        Thread t11= new Thread(runnable);
        t11.start();

        synchronized (t11){
            t11.wait();
        }
        System.out.println(runnable.total);
    }
}
