package Multi_Threading;

class A extends  Thread{
    public void run(){
        for(int i=0;i<=100;i++){
            System.out.println("hi");
        }
        for(int i=0;i<=100;i++){
            System.out.println("by");
        }
    }


}
class B extends  Thread{
    public void run(){
        for(int i=0;i<=100;i++){
            System.out.println("by");
        }
    }
}
public class A1_My_thread {
    public static void main(String[] args) {
        A obj=new A();
        B obj1 = new B();
        obj.start();
        System.out.println(obj.getPriority());
        obj.setPriority(8); // --> 0-10 (defualt 5)

        obj1.start();
    }
}
