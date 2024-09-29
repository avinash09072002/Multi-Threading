package Multi_Threading;

class Runnable1 implements  Runnable{
    public void run(){
        for(int i=0;i<200;i++){
            System.out.println("hi");
        }
    }
}
//class Runnable2 implements  Runnable{               ===== I Write this class using Lambda function =========
//    public void run(){
//        for(int i=0;i<20;i++){
//            System.out.println("hello");
//        }
//
//    }
//}


public class A3_Runnable {
    public static void main(String[] args) {
        Runnable obj1= new Runnable1();
        Thread t1= new Thread(obj1);
        t1.start();

        Runnable obj2=()->{
            for(int i=0;i<200;i++){
                System.out.println("hello");
            }

        };
        Thread t2= new Thread(obj2);
        t2.start();
    }
}
