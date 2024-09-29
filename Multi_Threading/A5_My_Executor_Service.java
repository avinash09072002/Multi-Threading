package Multi_Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class executerService implements Callable {
    public String call(){
        for(int i=0;i<-10;i++){
            System.out.println("i"+Thread.currentThread().getName());
        }

        return "task completed";
    }
}
public class A5_My_Executor_Service {

    public static void main(String[] args) {
        executerService service1= new executerService();
        executerService service2= new executerService();
        executerService service3= new executerService();

        ExecutorService serv= Executors.newFixedThreadPool(4);
        serv.submit(service1);
        serv.submit(service2);
        serv.submit(service3);

        Future<String> future=  serv.submit(service1);
        serv.shutdown();
        try{
            String  result= future.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
