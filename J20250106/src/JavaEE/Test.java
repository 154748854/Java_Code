package JavaEE;
class MyThread extends Thread {
    @Override
    public void run() {
        //这个方法就是线程的入口方法
        System.out.println("hello");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
