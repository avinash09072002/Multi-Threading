package Multi_Threading;
//
//import java.util.concurrent.Callable;
//
//class Callable1 implements Callable<Integer> {
//    @Override
//    public Integer call() {
//        return 4 + 5;
//    }
//}
//
//public class A4_Callable_interface {
//    public static void main(String[] args) {
//        // Create a Callable instance
//        Callable1 callable = new Callable1();
//
//        try {
//            // Directly call the call method
//            Integer result = callable.call();
//            System.out.println("Result from Callable1: " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
import java.util.concurrent.Callable;
        import java.util.concurrent.FutureTask;
        import java.util.concurrent.Future;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // Simulate some computation
        return 42;
    }
}

public class A4_Callable_interface {
    public static void main(String[] args) {
        // Create a Callable task
        MyCallable callableTask = new MyCallable();

        // Wrap the Callable in a FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);

        // Create a thread to run the FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // Get the result of the computation
            Integer result = futureTask.get();
            System.out.println("Result from Callable: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
