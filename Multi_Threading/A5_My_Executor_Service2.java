package Multi_Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class A5_My_Executor_Service2 {

    public static void main(String[] args) {
        Runnable runnable= ()->{
           for(int i=0;i<23;i++){
               System.out.println(i+Thread.currentThread().getName());
           }
        };
        Runnable runnable2= ()->{
            for(int i=0;i<23;i++){
                System.out.println(i+Thread.currentThread().getName());
            }
        };
        ExecutorService service= Executors.newFixedThreadPool(4);
        Future<String> future= service.submit(runnable,"task Completed");
        Future<String> future1= service.submit(runnable2,"task Completed 2");
        try{
            String result=future.get();
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }


        try{
            String result=future1.get();
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
