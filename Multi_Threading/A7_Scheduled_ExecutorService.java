package Multi_Threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class A7_Scheduled_ExecutorService {
    public static void main(String[] args) {
        Runnable obj= ()->{
            for(int i=0;i<23;i++){
                System.out.println(i+Thread.currentThread().getName());
            }
        };
        ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(3);
        scheduler.schedule(obj,5, TimeUnit.SECONDS);
    }
}
